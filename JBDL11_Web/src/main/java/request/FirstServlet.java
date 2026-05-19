package request;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class FirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Inside the init method");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Inside the service method");

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

       /* httpServletResponse.setContentType("text/plain");

        PrintWriter printWriter = httpServletResponse.getWriter();

        printWriter.println("<html><head></head><body><h1>This is Hreader</h1><p>this is paragraph</p></body></html>");

        */

        String pdfFilePath = "/Users/robin/Downloads/Admission_booklet.pdf";

        File pdfFile = new File(pdfFilePath);

        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setContentLengthLong(pdfFile.length());

        // IMPORTANT: inline tells browser to open it
        httpServletResponse.setHeader(
                "Content-Disposition",
                "attachment; filename=\"" + pdfFile.getName() + "\""
        );

        try (InputStream in = new FileInputStream(pdfFile);
             OutputStream out = httpServletResponse.getOutputStream()) {

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }





    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("Inside the destroy method");
    }
}
