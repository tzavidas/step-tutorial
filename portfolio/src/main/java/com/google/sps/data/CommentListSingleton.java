package com.google.sps.data;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.google.sps.dataExceptions.CommentExistingId;
import com.google.sps.dataExceptions.CommentNotFound;

class CommentListSingleton {
    private static CommentListSingleton instance;

    public static getInstance {
        if(instance == null) {
            instance = new CommentListSingleton();
        } else {
            return instance;
        }
    }

    private Map <Integer, Comment> commentsContainer;

    private CommentListSingleton() {
        this.commentsContainer = new HashMap<Integer, Comment>(); // hash table-like implementation (allows insertions, deletions and search by id in O(1))
    }

    public Comment getCommentById(int id) throws CommentNotFound {
        Comment retrievedComment = this.commentsContainer.get(id);

        if(retrievedComment == null) {
            throw new CommentNotFound(id);
        }

        return retrievedComment;
    }

    public List <Comment> getAllCommentsAsList() {
        List <Comment> commentsList = new ArrayList <Comment> (this.commentsContainer.values());

        return commentsList;
    }

    public void addComment(Comment newComment) throws CommentExistingId {
        int id = newComment.getId();

        if(this.commentsContainer.containsKey(id)) {
            throw new CommentExistingId(id);
        }

        this.commentsContainer.put(id, newComment); // add comment to our set
    }
}
