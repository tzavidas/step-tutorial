package com.google.sps.data;

public interface CommentBuilderImplementation {
    public void setId(long id);
    public void setName(String name);
    public void setDescription(String description);
    public void setPostDate(long timestamp);
    public Object build();
    public void reset();
}
