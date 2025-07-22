package com.example.sessiontracking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-cookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Cookie now: </h1>");

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies){
                if("username".equals(cookie.getName())) {
                    out.println("<p>User name: " + cookie.getValue() + "</p>");
                }
            }
        } else {
            out.println("<p>No cookies</p>");
        }
        out.println("<a href = 'index.jsp'>Back</a>");
        out.println("</body></html>");
    }
}
