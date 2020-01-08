import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "OrderSummaryServlet", urlPatterns = "/order-summary")

public class OrderSummaryServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String product = req.getParameter("productname");
        String quantity = req.getParameter("quantity");
        PrintWriter pw = res.getWriter();
        pw.println("<h1>Product:  "+ product +
                    "<br><br>" +
                    "Quantity: " + quantity + "</h1>"
                );
    }
}
