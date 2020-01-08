import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "PingServlet", urlPatterns = "/ping")

public class PingServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<form method=\"get\" action=\"/pong\">\n" +
                "  PING! <br>\n" +
                "  <input type=\"submit\" value=\"hit\">\n" +
                "</form>");

    }
}