//add contact as response to user action

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/AddContact")
public class AddContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //grab contact info from AddContact.jsp form
        String addFirstName = request.getParameter("firstName");
        String addLastName = request.getParameter("lastName");
        String addPhoneNumber = request.getParameter("phoneNumber");

        //create new contact
        Contact contact = new Contact(addFirstName, addLastName, addPhoneNumber);



        Contacts allContacts = DaoFactory.getContactsDao(); //
        allContacts.saveContact(contact);
        response.sendRedirect("/contacts");
    }


}