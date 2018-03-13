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
@WebServlet(name = "ShowCookies", urlPatterns = {"/ShowCookies"})
public class ShowCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/HTML");
        PrintWriter out = response.getWriter();
        String title = "Active Cookies";
        out.println(
                "<HTML>"
                + " <HEAD>"
                + "     <TITLE>" + title + "</TITLE>"
                + " </HEAD>"
                + " <BODY>"
                + "     <H1>" + title + "</H1>"
                + "     <TABLE border=\"1\" aling=\"center\">"
                + "         <TR>"
                + "             <TH>Cookie Name</TH>"
                + "             <TH>Cookie Value</TH>"
                + "         </TR>"
        );
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            out.println(
                "         <TR>"
                + "             <TD>" + cookie.getName() + "</TD>"
                + "             <TD>" + cookie.getValue() + "</TD>"
                + "         </TR>"
            );
        }
        out.println(
                "     </TABLE>"
                + " </BODY>"
                + "</HTML>"
        );
    }
}