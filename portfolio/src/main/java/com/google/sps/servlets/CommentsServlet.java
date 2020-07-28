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

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.PreparedQuery;

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

        ArrayList <Comment> allComments = (ArrayList)commentList.getAllCommentsAsList();

        Gson gson = new Gson();
        String commentsConverted = gson.toJson(allComments);

        response.setContentType("application/json;");
        response.getWriter().println(commentsConverted);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = this.sanitizeHtml(request.getParameter("name"));
        final String description = this.sanitizeHtml(request.getParameter("description"));
        final Long postDate = System.currentTimeMillis();

        try {
            CommentBuilder datastoreCommentBuilder = new CommentBuilder(CommentBuilderImplementationFactory.getDatastore());

            Entity newCommentEntity = (Entity)datastoreCommentBuilder
                .setName(name)
                .setDescription(description)
                .setPostDate(postDate)
                .build();

            this.datastoreService.put(newCommentEntity);

            response.getWriter().write("success");
        } catch(Exception e) {
            response.getWriter().write("failure");
        }
    }

    public String sanitizeHtml(String input) {
        String smallerThanReplaced = input.replace("<", "&lt;");
        String biggerThanReplaced = smallerThanReplaced.replace(">", "&gt;");

        return biggerThanReplaced;
    }

    private int nextId = 1;
}
