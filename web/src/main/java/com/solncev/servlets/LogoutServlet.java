package com.solncev.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println(String.format("JSESSIONID=%s", cookie.getValue()));
                }
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) {
            System.out.println(String.format("User=%s", httpSession.getAttribute("username")));
            httpSession.invalidate();
        }

        resp.sendRedirect("login.html");
    }
}
