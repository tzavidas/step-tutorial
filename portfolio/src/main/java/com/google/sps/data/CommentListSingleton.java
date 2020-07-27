package com.google.sps.data;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.google.sps.dataExceptions.ExistingCommentId;
import com.google.sps.dataExceptions.CommentNotFound;

public class CommentListSingleton {
    private static class SingletonHolder {
        private static final CommentListSingleton instance = new CommentListSingleton();
    }

    public static CommentListSingleton getInstance() {
        return SingletonHolder.instance;
    }

    // maps comment.id to the comment instance for fast look up by id
    private Map<Integer, Comment> commentContainer;

    private CommentListSingleton() {
        this.commentContainer = new HashMap<Integer, Comment>(); // hash table-like implementation (allows insertions, deletions and search by id in O(1))
    }

    public Comment getCommentById(int id) throws CommentNotFound {
        Comment retrievedComment = this.commentContainer.get(id);

        if(retrievedComment == null) {
            throw new CommentNotFound(id);
        }

        return retrievedComment;
    }

    public List<Comment> getAllCommentsAsList() {
        List<Comment> commentList = new ArrayList<Comment> (this.commentContainer.values());

        return commentList;
    }

    public void addComment(Comment newComment) throws ExistingCommentId {
        int id = newComment.getId();

        if(this.commentContainer.containsKey(id)) {
            throw new ExistingCommentId(id);
        }

        this.commentContainer.put(id, newComment); // add comment to our set
    }
}
