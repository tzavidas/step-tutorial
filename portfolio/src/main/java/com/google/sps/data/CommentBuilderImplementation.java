package com.google.sps.data;

public interface CommentBuilderImplementation {
    public void setId();
    public void setName();
    public void setDescription();
    public void setPostDate();
    public Object build();
    public void reset();
}
