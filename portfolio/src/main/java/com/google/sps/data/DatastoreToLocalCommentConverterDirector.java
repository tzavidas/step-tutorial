package com.google.sps.data;

import com.google.appengine.api.datastore.Entity;

public class DatastoreToLocalCommentConverterDirector {
    CommentBuilder localCommentBuilder;

    public DatastoreToLocalCommentConverterDirector() {
        this.localCommentBuilder = new CommentBuilder(CommentBuilderImplementationFactory.getLocal());
    }

    public Comment convert(Entity commentEntity) {
        long id = commentEntity.getKey().getId();
        String name = (String)commentEntity.getProperty("name");
        String description = (String)commentEntity.getProperty("description");
        long postDate = (long) commentEntity.getProperty("postDate");

        Comment localComment = (Comment)this.localCommentBuilder
            .setId(id)
            .setName(name)
            .setDescription(description)
            .setPostDate(postDate)
            .build();

        this.localCommentBuilder.reset();

        return localComment;
    }
}
