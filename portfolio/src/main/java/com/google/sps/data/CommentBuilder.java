package com.google.sps.data;

public class CommentBuilder {
    private CommentBuilderImplementation implementation;

    public CommentBuilder(CommentBuilderImplementation implementation) {
        this.implementation = implementation;
    }

    public CommentBuilder setId(int id) {
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

    public CommentBuilder setPostDate(Object postDate) {
        this.implementation.setPostDate(postDate);

        return this;
    }

    private void reset() {
        this.implementation.reset();
    }

    public Object build() {
        Object builtComment = this.implementation.build();

        return builtComment;
    }
}
