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

import com.google.sps.dataExceptions.ExistingCommentId;

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
        final String name = this.sanitizeHtml(request.getParameter("name"));
        final String description = this.sanitizeHtml(request.getParameter("description"));
        
        final Date postDate = new Date(); // defaults to the current system's date

        final int idToUse = nextId;
        nextId++; // increase the id number to be used on the subsequent requests (similar to AUTO_INCREMENT)

        response.setContentType("text/plain;");

        try {
            this.commentList.addComment(this.commentBuilder
                .setId(idToUse)
                .setName(name)
                .setDescription(description)
                .setPostDate(postDate)
                .build()
            );

            response.getWriter().write("success");
        } catch(ExistingCommentId e) {
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
