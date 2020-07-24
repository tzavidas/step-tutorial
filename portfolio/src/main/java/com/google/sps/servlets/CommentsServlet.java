package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.google.sps.data.Comment;
import com.google.sps.data.CommentBuilder;
import com.google.sps.data.CommentListSingleton;

import com.google.sps.dataExceptions.CommentExistingId;

import java.io.PrintStream;

@WebServlet("/comments")
public final class CommentsServlet extends HttpServlet {
    private CommentListSingleton commentList = CommentListSingleton.getInstance();
    private CommentBuilder commentBuilder = new CommentBuilder();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List <Comment> allComments = commentList.getAllCommentsAsList();


        Gson gson = new Gson();
        
        String commentsConverted = gson.toJson(allComments);

        response.setContentType("application/json;");
        response.getWriter().println(commentsConverted);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        final String description = request.getParameter("description");
        
        final Date postDate = new Date(); // defaults to the current system's date

        final int idToUse = nextId;
        nextId++; // increase the id number to be used on the subsequnt requests (similar to AUTO_INCREMENT)

        Comment newComment = this.commentBuilder
            .setId(idToUse)
            .setName(name)
            .setDescription(description)
            .setPostDate(postDate)
            .build();

        response.setContentType("text/plain;");

        try {
            this.commentList.addComment(newComment);

            response.getWriter().write("success");
        } catch(CommentExistingId e) {
            response.getWriter().write("failure");
        }
    }

    private int nextId = 1;
}
