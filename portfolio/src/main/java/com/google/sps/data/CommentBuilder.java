package com.google.sps.data;

import java.util.Date;

public class CommentBuilder {
    public CommentBuilder() {
        this.comment = new Comment();
    }

    public CommentBuilder setId(int id) {
        this.comment.setId(id);

        return this;
    }

    public CommentBuilder setName(String name) {
        this.comment.setName(name);

        return this;
    }

    public CommentBuilder setDescription(String description) {
        this.comment.setDescription(description);

        return this;
    }

    public CommentBuilder setPostDate(Date postDate) {
        this.comment.setPostDate(postDate);

        return this;
    }

    private void resetProcess() {
        this.comment = new Comment();
    }

    public Comment build() {
        Comment builtComment = this.comment;
        this.resetProcess();

        return builtComment;
    }

    private Comment comment;
}
