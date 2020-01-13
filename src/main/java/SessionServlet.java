import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("sesAt", "Session Attribute");
        session.setAttribute("name", "roger");

        //set interval
        session.setMaxInactiveInterval(5);

//        //create cart
//        Cart cart = new Cart();
//        cart.setNumItems(7);
//        session.setAttribute("cart", cart);

        //set a request attribute
        request.setAttribute("reqAt", "Request Attribute");

        //set a context attribute
        ServletContext context = getServletContext();
       context.setAttribute("conAt", "Context Attribute");

        request.getRequestDispatcher("/session.jsp").forward(request,response);

    }

}
