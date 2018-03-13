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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = null;
        String password = null;
        Cookie[] cookies = req.getCookies();
        if ((cookies != null) && (cookies.length > 0)) {
            //Ho cookies. Verifico che sia un utente valido.
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "Username":
                        username = cookie.getValue();
                        break;
                    case "Password":
                        password = cookie.getValue();
                        break;
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(
                "<html>\n"
                + " <head>\n"
                + "     <title>Login DEMO</title>\n"
                + " </head>\n"
                + " <body>\n"
        );
        if ((username == null) || (password == null)) {
            //Utente non valido, chiedo il login!
            out.println(
                    "       <div id=\"login\">\n"
                    + "         <form id=\"loginForm\" action=\"LoginServlet\" method=\"POST\">\n"
                    + "             Username: <input name=\"username\" type=\"text\" required><br>\n"
                    + "             Password: <input name=\"password\" type=\"password\" required><br>\n"
                    + "             <input type=\"submit\" value=\"Login\">\n"
                    + "         </form>\n"
                    + "     </div>\n"
            );
        } else {
            //Utente valido, visualizzo i dati!
            out.println("<h1>User logged in</h1>" +
                    "       <table>\n"
                    + "         <tr><th>Username</th><th>Password</th></tr>\n"
                    + "         <tr><td>" + username + "</td><td>" + password + "</td></tr>\n"
                    + "     </table>\n"
            );
        }
        
        out.println("</body>\n</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ((username == null) || (password == null)) {
            //Login not valid
            resp.sendRedirect("LoginServlet");
        } else {
            Cookie cookie = new Cookie("Username", username);
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            cookie = new Cookie("Password", password);
            resp.addCookie(cookie);
            cookie.setMaxAge(60);
            resp.sendRedirect("LoginServlet");
        }
    }

}
