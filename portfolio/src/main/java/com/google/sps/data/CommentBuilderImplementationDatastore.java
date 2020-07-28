package com.google.sps.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;

import java.lang.UnsupportedOperationException;

public class CommentBuilderImplementationDatastore implements CommentBuilderImplementation {
    private DatastoreService datastoreService;
    private Entity commentEntity;

    public CommentBuilderImplementationDatastore() {
        this.reset();
    }

    @Override
    public void setId(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setName(String name) {
        this.commentEntity.setProperty("name", name);
    }

    @Override
    public void setDescription(String description) {
        this.commentEntity.setProperty("description", description);
    }

    @Override
    public void setPostDate(long timestamp) {
        this.commentEntity.setProperty("postDate", timestamp);
    }

    @Override
    public void reset() {
        this.commentEntity = new Entity("Comment");
    }

    @Override
    public Object build() {
        return this.commentEntity;
    }
}
