package com.google.sps.data;

public class CommentBuilderImplementationFactory {
    public static CommentBuilderImplementationLocal getLocal() {
        return new CommentBuilderImplementationLocal();
    }

    public static CommentBuilderImplementationDatastore getDatastore() {
        return new CommentBuilderImplementationDatastore();
    }
}
