/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.disi.unitn.webprogramming.servlet.loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mughead
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        StringBuilder html = new StringBuilder("<html><head><title>Logout page</title></head><body>");
        if ((cookies != null) && (cookies.length > 0)) {
            html.append("<h1>Logging out of page</h1>");
            html.append("<table>");

            for (Cookie cookie: cookies) {
                html.append("<tr><td>").append(cookie.getName()).append("</td><td>").append(cookie.getValue()).append("</tr>");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
            html.append("</table>");
        } else {
            html.append("<h2>No User logged in found</h2>");
        }
        html.append("</body></html>");
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(html);
    }   

}
