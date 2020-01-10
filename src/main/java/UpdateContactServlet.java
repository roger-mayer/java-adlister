import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Contacts contactDao = DaoFactory.getContactsDao();
        Contact updateContact = contactDao.getContactById(id);

        request.setAttribute("id", id);
        request.getRequestDispatcher("/UpdateContact.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //grab contact info from UpdateContact.jsp form
        String FirstName = request.getParameter("firstName");
        String LastName = request.getParameter("lastName");
        String PhoneNumber = request.getParameter("phoneNumber");

//        //create new contact
//        Contact contact = new Contact(addFirstName, addLastName, addPhoneNumber);
//        Contacts allContacts = DaoFactory.getContactsDao(); //
//        allContacts.saveContact(contact);
////        List<Contact> contacts = allContacts.getContacts();
////        request.setAttribute("contacts", contacts);
////        request.getRequestDispatcher("ContactsManager/ContactsIndex.jsp").forward(request, response);
//        response.sendRedirect("/contacts");
    }



}
