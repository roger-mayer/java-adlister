import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name="/loginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet{

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("password")){
            req.setAttribute("username", username);
            req.getRequestDispatcher("/profile").forward(req, res);
        } else {
            res.sendRedirect("/login");
        }

    }


}
