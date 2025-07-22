package com.example.sessiontracking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/add-product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        String sessionID = req.getParameter("sessionID");
        if(sessionID == null || sessionID.isEmpty()){
            sessionID = UUID.randomUUID().toString();
        }
        String productName = req.getParameter("productName");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Product Added</h1>");
        out.println("<p> sessionID: " + sessionID + "</p>");
        out.println("<p>Product Name: " + (productName != null ? productName : "Null") + "</p>");
        out.println("<a href = '" + resp.encodeURL("form.jsp?sessionId=" + sessionID) + " '>Add other product</a>");
        out.println("</body></html>");

    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }
}
