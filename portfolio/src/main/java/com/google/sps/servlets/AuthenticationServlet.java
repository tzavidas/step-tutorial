package com.google.sps.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.lang.System;

@WebServlet("/user/*")
public final class AuthenticationServlet extends HttpServlet {
    private UserService userService = UserServiceFactory.getUserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();

        switch(this.getActionPath(uri)) { // REVIEW: is this acceptable? or shall I use uri above?
            case "login":
                this.doLogin(request, response);
                break;

            case "logout":
                this.doLogout(request, response);
                break;

            case "data":
                this.doGetData(request, response);
                break;

            default:
                this.doHandleDefault(request, response);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String redirectUrl = request.getContextPath() + "/";

        if(this.userService.isUserLoggedIn()) {
            response.sendRedirect(redirectUrl);
        } else {
            response.sendRedirect(this.userService.createLoginURL(redirectUrl));
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String redirectUrl = request.getContextPath() + "/";

        if(this.userService.isUserLoggedIn()) {
            response.sendRedirect(this.userService.createLogoutURL(redirectUrl));
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    private void doGetData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;");

        if(this.userService.isUserLoggedIn()) {
            response.getWriter().write(this.userService.getCurrentUser().getEmail());
        } else {
            response.getWriter().write("false");
        }
    }

    private void doHandleDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * Extracts the type of action needed to be taken based on the URI.
     * @param uri the page's uri in the form /user/[action]
     * @return [action] if it does not contain any slashes, otherwise an empty string
     */
    private String getActionPath(String uri) {
        uri = uri.substring(1); // discard the leftmost slash

        String []splitBySlashes = uri.split("/");

        if(splitBySlashes.length >= 3 || splitBySlashes.length <= 1) { // unacceptable number of overall slashes
            return "";
        }

        return splitBySlashes[1];
    }
}
