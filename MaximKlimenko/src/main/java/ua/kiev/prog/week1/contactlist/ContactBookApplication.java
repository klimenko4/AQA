package ua.kiev.prog.week1.contactlist;

public class ContactBookApplication {
    public static void main(String[] args) {
        Contact contact1 = new Contact("James Cogan", "0634445556");
        Contact contact2 = new Contact("Arthur Litt", "0674445673");

        ContactBook contactBook = new ContactBook();

        contactBook.addContact(contact1);
        contactBook.addContact(contact2);

      //  contactBook.findContactByName("Arthur");
     //   contactBook.removeLast();
        contactBook.showAllContacts();
    }

}