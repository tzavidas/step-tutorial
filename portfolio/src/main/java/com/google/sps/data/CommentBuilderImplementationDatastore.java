package com.google.sps.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;

java.lang.UnsupportedOperationException;

public class CommentBuilderImplementationDatastore extends CommentBuilderImplementation {
    private DatastoreService datastoreService;
    private Entity commentEntity;

    public CommentBuilderImplementationDatastore() {
        this.reset();
    }

    public void  setId(int id) throws UnsupportedOperationException {
        throw UnsupportedOperationException;
    }

    public void setName(String name) {
        this.commentEntity.setProperty("name", name);
    }

    public void setDescription(String description) {
        this.commentEntity.setProperty("description", description);
    }

    public CommentBuilder setPostDate(Long timestamp) {
        this.commentEntity.setProperty("postDate", timestamp);
    }

    private void reset() {
        this.commentEntity = new Entity("Comment");
    }

    public Comment build() {
        return this.commentEntity;
    }
}