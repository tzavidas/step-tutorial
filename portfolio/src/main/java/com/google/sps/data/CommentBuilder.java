package com.google.sps.data;

public class CommentBuilder {
    private CommentBuilderImplementation implementation;

    public CommentBuilder(CommentBuilderImplementation implementation) {
        this.implementation = implementation;
    }

    public CommentBuilder setId(long id) {
        this.implementation.setId(id);

        return this;
    }

    public CommentBuilder setName(String name) {
        this.implementation.setName(name);

        return this;
    }

    public CommentBuilder setDescription(String description) {
        this.implementation.setDescription(description);

        return this;
    }

    public CommentBuilder setPostDate(long postDate) {
        this.implementation.setPostDate(postDate);

        return this;
    }

    public void reset() {
        this.implementation.reset();
    }

    public Object build() {
        Object builtComment = this.implementation.build();

        return builtComment;
    }
}
