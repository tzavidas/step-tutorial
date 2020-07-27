package com.google.sps.data;

import java.util.Date;

public class Comment {
    public Comment() {

    }

    private Comment(int id, String name, String description, Date postDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.postDate = postDate;
    }

    private int id;
    private String name;
    private String description;
    private Date postDate;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDate() {
        return postDate;
    }
}
