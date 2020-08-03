package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;

import com.google.sps.data.Comment;
import com.google.sps.data.CommentList;
import com.google.sps.data.CommentBuilder;
import com.google.sps.data.CommentBuilderImplementationFactory;
import com.google.sps.data.DatastoreToLocalCommentConverterDirector;
import com.google.sps.data.BlobRequestParser;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.PreparedQuery;

import com.google.appengine.api.users.UserServiceFactory;

import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;

import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.PrintStream;

@WebServlet("/comments")
public final class CommentsServlet extends HttpServlet {
    private DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Query query = new Query("Comment").addSort("postDate", SortDirection.ASCENDING);
        PreparedQuery results = this.datastoreService.prepare(query);

        CommentList commentList = new CommentList();

        DatastoreToLocalCommentConverterDirector converterDirector = new DatastoreToLocalCommentConverterDirector();

        for(Entity commentEntity : results.asIterable()) {
            Comment currComment = converterDirector.convert(commentEntity);

            commentList.addComment(currComment);
        }

        List<Comment> allComments = commentList.getAllCommentsAsList();

        Gson gson = new Gson();
        String commentsConverted = gson.toJson(allComments);

        response.setContentType("application/json;");
        response.getWriter().println(commentsConverted);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BlobRequestParser requestParser = new BlobRequestParser(request);

        final String name = this.sanitizeHtml(requestParser.getTextParameter("name"));
        final String description = this.sanitizeHtml(requestParser.getTextParameter("description"));
        final Long postDate = System.currentTimeMillis();
        final List<BlobKey> imageFiles = requestParser.getFileListByParameter("images");

        try {
            if(!this.isAuthenticated()) {
                throw new Exception();
            }
            
            List<String> imageUrls = new ArrayList<>();

            for(BlobKey imageBlobKey : imageFiles) {
                imageUrls.add(this.getUploadedUrl(imageBlobKey));
            }

            CommentBuilder datastoreCommentBuilder = new CommentBuilder(CommentBuilderImplementationFactory.getDatastore());

            Entity newCommentEntity = (Entity)datastoreCommentBuilder
                .setName(name)
                .setDescription(description)
                .setPostDate(postDate)
                .setImages(imageUrls)
                .build();

            this.datastoreService.put(newCommentEntity);

            response.getWriter().write("success");
        } catch(Exception e) {
            response.getWriter().write("failure");
        }
    }

    private String getUploadedUrl(BlobKey blobKey) {
        BlobInfo blobInfo = new BlobInfoFactory().loadBlobInfo(blobKey);

        if(blobInfo.getSize() == 0) { // no file was uploaded
            BlobstoreServiceFactory.getBlobstoreService().delete(blobKey);

            return null;
        }

        ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blobKey);
        ImagesService imagesService = ImagesServiceFactory.getImagesService();

        try {
            String imageUrl = imagesService.getServingUrl(options);

            URL url = new URL(imageUrl);
            return url.getPath();
        } catch(MalformedURLException e) {
            return imagesService.getServingUrl(options);
        }
    }

    private Boolean isAuthenticated() {
        return UserServiceFactory.getUserService().isUserLoggedIn();
    }

    public String sanitizeHtml(String input) {
        String smallerThanReplaced = input.replace("<", "&lt;");
        String biggerThanReplaced = smallerThanReplaced.replace(">", "&gt;");

        return biggerThanReplaced;
    }

    private int nextId = 1;
}
