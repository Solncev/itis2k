package com.solncev.servlets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloServletTest {

    private final HelloServlet servlet = new HelloServlet();
    private HttpServletResponse response;
    private HttpServletRequest request;

    @Before
    public void setup() {
        response = Mockito.mock(HttpServletResponse.class);
        request = Mockito.mock(HttpServletRequest.class);
    }

    @Test
    public void testHello() throws IOException {
        Mockito.when(request.getParameter("name")).thenReturn("Ivan");

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Mockito.when(response.getWriter()).thenReturn(printWriter);

        servlet.doGet(request, response);

        printWriter.flush();
        Mockito.verify(request, Mockito.times(1)).getParameter("name");
        Assert.assertEquals("Hello, Ivan!", stringWriter.toString());
    }
}
