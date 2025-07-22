package com.example.sessiontracking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/set-cookie")
public class CookieServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");

        Cookie cookie = new Cookie("username", username != null ? username: "Khách");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Cookie save successful</h1>");
        out.println("<p>Name: " + username + "</p>");
        out.println("<a href = 'get-cookie'>View Cookie</a>");
        out.println("</body></html>");
    }
}
