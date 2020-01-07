import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    int hitCount = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        if (name == null || name.equals("")) {
            res.setContentType("text/html");
            hitCount++;
            PrintWriter pw = res.getWriter();
            pw.println("<h1>Hello, World!</h1>");
            pw.println("<h1>Hitcount is " + hitCount + "!</h1>");
        } else if (name.equalsIgnoreCase("resetcounter")){
            res.setContentType("text/html");
            hitCount = 0;
            PrintWriter pw = res.getWriter();
            pw.println("<h1>Hello, World!</h1>");
            pw.println("<h1>Hitcount is " + hitCount + "!</h1>");
        } else {
            res.setContentType("text/html");
            hitCount++;
            PrintWriter pw = res.getWriter();
            pw.println("<h1>Hello, " + name + "!</h1>");
            pw.println("<h1>Hitcount is " + hitCount + "!</h1>");
        }
    }
}