package com.google.sps.dataExceptions;

public class CommentExistingId extends Exception {
    private int id;

    public CommentExistingId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("Comment with id %d already exists!", this.id);
    }
}
