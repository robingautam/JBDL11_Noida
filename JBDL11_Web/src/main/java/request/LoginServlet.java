package request;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name =  req.getParameter("name");
      String email = req.getParameter("email");
      String message = req.getParameter("message");

      resp.setContentType("text/html");

      PrintWriter printWriter = resp.getWriter();

      printWriter.println("<html><head></head><body><h1>Welcome "+name+"</h1><p>your email is "+email+"</p></body></html>");
    }
}
