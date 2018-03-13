/*
 * AA 2017-2018
 * Introduction to Web Programming
 * Lab 04 - Example 01
 * UniTN
 */
package it.unitn.aa1718.webprogramming.lab04.exercise01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Test of {@link Servlet} class and {@link Cookie} class.
 *
 * @author Stefano Chirico &lt;stefano dot chirico at unitn dot it&gt;
 * @since 2018.03.12
 */
public class DeleteCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        StringBuilder html = new StringBuilder("<html><head><title>Delete cookies</title></head><body>");
        if ((cookies != null) && (cookies.length > 0)) {
            html.append("<table><tr><th>Nome</th><th>Valore</th></tr>");
            for (Cookie cookie: cookies) {
                html.append("<tr><td>").append(cookie.getName()).append("</td><td>").append(cookie.getValue()).append("</tr>");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
            html.append("</table>");
        } else {
            html.append("<h2>No Cookies found</h2>");
        }
        html.append("</body></html>");
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(html);
    }   
}