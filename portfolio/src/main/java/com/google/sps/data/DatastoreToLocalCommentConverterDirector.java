package com.google.sps.data;

import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;

import java.util.List;

public class DatastoreToLocalCommentConverterDirector {
    public Comment convert(Entity commentEntity) {
        long id = commentEntity.getKey().getId();
        String name = (String)commentEntity.getProperty("name");
        String description = (String)commentEntity.getProperty("description");
        long postDate = (long)commentEntity.getProperty("postDate");

        String imagesJson = (String)commentEntity.getProperty("images");
        List<String> images = new Gson().fromJson(imagesJson, new TypeToken<List<String>>() {}.getType());

        return (Comment)new CommentBuilder(CommentBuilderImplementationFactory.getLocal())
            .setId(id)
            .setName(name)
            .setDescription(description)
            .setPostDate(postDate)
            .setImages(images)
            .build();
    }
}
