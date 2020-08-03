package com.google.sps.data;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.blobstore.BlobKey;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public final class BlobRequestParser {
    private HttpServletRequest request;

    public BlobRequestParser(HttpServletRequest request) {
        this.request = request;
    }

    public String getTextParameter(String name) {
        return this.request.getParameter(name);
    }

    public List<BlobKey> getFileListByParameter(String parameterName) {
        Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(this.request);

        List<BlobKey> files = blobs.get(parameterName);

        if(files == null || files.isEmpty()) {
            return new ArrayList<BlobKey>(); // empty list
        } else {
            return files;
        }
    }
}
