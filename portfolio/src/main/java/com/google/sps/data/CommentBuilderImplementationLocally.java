package com.google.sps.data;

public class CommentBuilderImplementationLocally extends CommentBuilderImplementation {
    private Comment comment;

    public CommentBuilderImplementationLocally() {
        this.comment = new Comment();
    }

    public void  setId(int id) {
        this.comment.setId(id);
    }

    public void setName(String name) {
        this.comment.setName(name);
    }

    public void setDescription(String description) {
        this.comment.setDescription(description);
    }

    public CommentBuilder setPostDate(Date postDate) {
        this.comment.setPostDate(postDate);
    }

    private void reset() {
        this.comment = new Comment();
    }

    public Comment build() {
        Comment builtComment = this.comment;

        return builtComment;
    }
}