package models;

import java.util.List;

public interface Contacts {
    // get a list of all the contacts
    List<Contact> all();
    // insert a new ad and return the new contact's id
    Long insert(Contact contact);
}
