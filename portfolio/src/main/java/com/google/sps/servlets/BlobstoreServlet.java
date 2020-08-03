package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@WebServlet("/blob-store-2")
final class BlobstoreServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String commentPostUri = "/comments";

        String blobUrl = BlobstoreServiceFactory.getBlobstoreService().createUploadUrl(commentPostUri);

        response.setContentType("text/plain;");
        response.getWriter().write(blobUrl);
    }
}

