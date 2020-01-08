import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<form method=\"post\" action=\"/order-summary\">\n" +
                "  Product Name:<br>\n" +
                "  <input type=\"text\" name=\"productname\"><br>\n" +
                "  Quantity:<br>\n" +
                "  <input type=\"text\" name=\"quantity\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");

    }
}
