package com.google.sps.data;

import java.util.List;
import java.util.ArrayList;

public class CommentList {
    private List <Comment> commentList;

    public CommentList() {
        this.commentList = new ArrayList <Comment>();
    }

    public CommentList(List <Comment> commentList) {
        this.commentList = commentList;
    }

    public List <Comment> getAllCommentsAsList() {
        return this.commentList;
    }

    public void addComment(Comment newComment) {
        this.commentList.add(newComment);
    }
}
