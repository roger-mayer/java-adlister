//interface
import java.util.List;

//define methods used in DAO
public interface Contacts {
    List<Contact> getContacts();
    long saveContact(Contact contact);
    void deleteContactById(long id);
    Contact getContactById(long id);

}