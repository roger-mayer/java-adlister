import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/rejected.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting master access code (password)
        String sessionCode = (String) request.getSession().getAttribute("access_code");
        System.out.println("Session code: " + sessionCode);

        //get the code the user typed in

        String requestCode = (String) request.getParameter("code");
        System.out.println("Access code: " + requestCode);

        //check for access session not initialized
        if (sessionCode == null || requestCode == null){
            request.getRequestDispatcher("/WEB-INF/rejected.jsp").forward(request,response);

        }
        else if (requestCode.equals(sessionCode)){
            //if correct code, go to admin page
            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request,response);
        } else {
            //if code does not match, reject request
            request.getRequestDispatcher("/WEB-INF/rejected.jsp").forward(request,response);

        }
    }
}
