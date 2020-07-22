package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.google.sps.data.Comment;
import com.google.gson.Gson;

@WebServlet("/comments")
public final class CommentsServlet extends HttpServlet {
    private List <Comment> getCommentsList() {
        ArrayList <Comment> commentsList = new ArrayList <Comment>();

        commentsList.add(new Comment(1, "Max B", "Hello y'all!", new Date(1595320478000L)));
        commentsList.add(new Comment(2, "Maksim S", "Hey folks!", new Date(1595322478000L)));
        commentsList.add(new Comment(3, "Remus N", "Hey Everyone!", new Date(1595324478000L)));
        commentsList.add(new Comment(4, "Nick T", "Welcome everyone! Have fun! :)", new Date(1595326478000L)));

        return commentsList;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List <Comment> allComments = getCommentsList();

        Gson gson = new Gson();
        
        String commentsConverted = gson.toJson(allComments);

        response.setContentType("application/json;");
        response.getWriter().println(commentsConverted);
    }
}
