import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", id);
        Contacts contactDao = DaoFactory.getContactsDao();
        Contact updatePerson = contactDao.getContactById(id);
        request.setAttribute("updatePerson", updatePerson);
        request.getRequestDispatcher("contacts/updateContact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contacts contactDao = DaoFactory.getContactsDao();
        long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("updateFirstName");
        String lastName = request.getParameter("updateLastName");
        String phoneNumber = request.getParameter("updateNumber");
        Contact contact = new Contact(id, firstName,lastName,phoneNumber);
        contactDao.saveContact(contact);
        response.sendRedirect("/contacts");
    }



}
