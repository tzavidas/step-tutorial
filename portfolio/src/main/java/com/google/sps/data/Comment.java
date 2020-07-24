package com.google.sps.data;

import java.util.Date;

public class Comment {
    public Comment() {

    }

    public Comment(long id, String name, String description, long postDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.postDate = postDate;
    }

    private long id;
    private String name;
    private String description;
    private long postDate;

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
}
