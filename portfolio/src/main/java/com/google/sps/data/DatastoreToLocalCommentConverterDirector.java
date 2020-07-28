package com.google.sps.data;

import com.google.appengine.api.datastore.Entity;

public class DatastoreToLocalCommentConverterDirector {
    public Comment convert(Entity commentEntity) {
        long id = commentEntity.getKey().getId();
        String name = (String)commentEntity.getProperty("name");
        String description = (String)commentEntity.getProperty("description");
        long postDate = (long) commentEntity.getProperty("postDate");

        return (Comment)new CommentBuilder(CommentBuilderImplementationFactory.getLocal())
            .setId(id)
            .setName(name)
            .setDescription(description)
            .setPostDate(postDate)
            .build();
    }
}
