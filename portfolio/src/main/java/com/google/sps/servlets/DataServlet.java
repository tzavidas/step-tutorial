// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.lang.Math;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    private final static String[] Nicknames = { "Nick", "nicktz1408", "Nikolaos", "an intern Googler", "a Noogler", "a STEPer" };

  @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final int namesLen = Nicknames.length;

        final int randomIndex = (int)Math.floor(Math.random() * namesLen);
        final String renderedName = Nicknames[randomIndex];

        PrintWriter writer = response.getWriter();

        response.setContentType("text/html;");
        writer.println("Greeting from " + renderedName + "!");
    }
}
