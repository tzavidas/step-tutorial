package com.google.sps.dataExceptions;

public class ExistingCommentId extends Exception {
    private int id;

    public ExistingCommentId(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("Comment with id %d already exists!", this.id);
    }
}
