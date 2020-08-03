package com.google.sps.data;

import java.util.List;

public interface CommentBuilderImplementation {
    public void setId(long id);
    public void setName(String name);
    public void setDescription(String description);
    public void setPostDate(long timestamp);
    public void setImages(List<String> images);
    public Object build();
    public void reset();
}
