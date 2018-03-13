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
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "SetCookies", urlPatterns = {"/SetCookies"})
public class SetCookies extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (int i = 0; i < 3; i++) {
            Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
            cookie.setMaxAge(-1);//Valid only for the current browsing session
            response.addCookie(cookie);

            cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
            cookie.setMaxAge(3600);//Expires in one hour.
            response.addCookie(cookie);
        }

        response.setContentType("text/HTML");
        PrintWriter out = response.getWriter();
        String title = "Setting Cookies";
        out.println(
                "<HTML>"
                + " <HEAD>"
                + "     <TITLE>" + title + "</TITLE>"
                + " </HEAD>"
                + " <BODY>"
                + "     <H1>" + title + "</H1>"
                + "     There are six cookies associated with this page."
                + " </BODY>"
                + "</HTML>"
        );
    }
}