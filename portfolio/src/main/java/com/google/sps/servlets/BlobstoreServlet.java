package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import java.net.URL;

@WebServlet("/blobstore")
public final class BlobstoreServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String commentPostUri = "/comments";

        String blobUrl = new URL(BlobstoreServiceFactory.getBlobstoreService().createUploadUrl(commentPostUri)).getPath();

        response.setContentType("text/plain;");
        response.getWriter().write(blobUrl);
    }
}
