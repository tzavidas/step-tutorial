package com.google.sps.data;

import java.util.Date;
import java.util.List;

public class Comment {
    private long id;
    private String name;
    private String description;
    private long postDate;
    private List<String> images;

    Comment() {
    }

    Comment(long id, String name, String description, long postDate, List<String> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.postDate = postDate;
        this.images = images;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPostDate(long postDate) {
        this.postDate = postDate;
    }

    public long getPostDate() {
        return postDate;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return this.images;
    }
}
