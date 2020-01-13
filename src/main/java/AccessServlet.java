import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/access")
public class AccessServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.getSession().setAttribute("access_code", "password"); //setting literal
    request.getRequestDispatcher("/WEB-INF/access.jsp").forward(request,response); //forwarding info from jsp form
   }
}
