package com.example.sessiontracking;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "setCookie", value ={"/set-cookie", "/get-cookie"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");

        Cookie cookie = new Cookie("username", username != null ? username : "Khachs");
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.print("<h1>Cookie da duoc luu</h1>");
        out.print("Ten nguoi dung: " + username + "</p>");
        out.println("<a href='get-cookie'>Xem cookie</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Cookie hiện tại:</h1>");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    out.println("<p>Tên người dùng: " + cookie.getValue()
                            + "</p>");
                }
            }
        } else {
            out.println("<p>Không tìm thay cookie!</p>");
        }
        out.println("<a href='index.html'>Quay lại</a>");
        out.println("</body></html>");

    }
}
