package com.google.sps.data;

import java.util.Date;

public class Comment {
    public Comment(int id, String name, String description, Date postDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.postDate = postDate;
    }

    private final int id;
    private final String name;
    private final String description;
    private final Date postDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getPostDate() {
        return postDate;
    }
} 