package com.solncev.handlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/handle")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleException(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleException(req, resp);
    }

    private void handleException(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
        uri = uri == null ? "Unknown" : uri;

//        response.setContentType("text/html");
//
//        PrintWriter output = response.getWriter();
//        output.write("<html><head> <title>Exception Details </title></head><body>");
//        if (statusCode != 500) {
//            output.write("<h2> Error Details </h2>");
//            output.write("<strong> Status code </strong>" + statusCode + " <br>");
//            output.write("<strong> Request uri </strong>" + uri + "<br>");
//        } else {
//            output.write("<h2> Exception Details </h2>");
//            output.write("<strong> Status code </strong>" + statusCode + " <br>");
//            output.write("<strong> Request uri </strong>" + uri + "<br>");
//            output.write("<strong> Exception Message: </strong>"+throwable.getMessage()+"<br>");
//        }
//
//        output.write("</body></html>");


        request.setAttribute("statusCode", statusCode);
        request.setAttribute("uri", uri);
        if (statusCode == 500) {
            request.setAttribute("message", throwable.getMessage());
        }

        request.getRequestDispatcher("exception.ftl").forward(request,response);
    }
}
