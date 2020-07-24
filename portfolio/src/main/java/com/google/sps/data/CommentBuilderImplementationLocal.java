package com.google.sps.data;

import java.util.Date;

public class CommentBuilderImplementationLocal implements CommentBuilderImplementation {
    private Comment comment;

    public CommentBuilderImplementationLocal() {
        this.comment = new Comment();
    }

    @Override
    public void  setId(long id) {
        this.comment.setId(id);
    }

    @Override
    public void setName(String name) {
        this.comment.setName(name);
    }

    @Override
    public void setDescription(String description) {
        this.comment.setDescription(description);
    }

    @Override
    public void setPostDate(long postDate) {
        this.comment.setPostDate(postDate);
    }

    @Override
    public void reset() {
        this.comment = new Comment();
    }

    public Object build() {
        Comment builtComment = this.comment;

        return builtComment;
    }
}
