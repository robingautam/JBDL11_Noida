package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = resp;

        httpServletResponse.setContentType("text/plain");

        PrintWriter printWriter = httpServletResponse.getWriter();

        printWriter.println("<html><head></head><body><h1>This is Hreader</h1><p>this is paragraph</p></body></html>");

    }
}
