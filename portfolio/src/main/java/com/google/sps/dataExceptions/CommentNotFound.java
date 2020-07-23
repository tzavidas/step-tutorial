package com.google.sps.dataExceptions;

public class CommentNotFound extends Exception {
    private int id;

    public CommentNotFound(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("No comment with id %d has been found!", this.id);
    }
}
