package com.solncev.servlets;

import com.solncev.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private static final List<UserDto> USERS = Arrays.asList(
            new UserDto("Ivan", "Ivanov"),
            new UserDto("Ivan", "Sergeev"),
            new UserDto("Ivan", "Nikitin"),
            new UserDto("Ivan", "Borisov")

    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", USERS);
        req.getRequestDispatcher("page.ftl").forward(req, resp);
    }
}
