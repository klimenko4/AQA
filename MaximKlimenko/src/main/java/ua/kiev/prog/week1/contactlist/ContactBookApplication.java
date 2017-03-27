package ua.kiev.prog.week1.contactlist;

public class ContactBookApplication {
    public static void main(String[] args) {
        Contact contact1 = new Contact("James Cogan", "0634445556");
        Contact contact2 = new Contact("Arthur Litt", "0674445673");
        Contact contact3 = new Contact("Arthur Li33", "0674445674");
        Contact contact4 = new Contact("Arthur Li44", "0674445675");
        Contact contact5 = new Contact("Arthur Li55", "0674445675");
        Contact contact6 = new Contact("Arthur Li66", "0674445675");
        Contact contact7 = new Contact("Arthur Li77", "0674445675");
        Contact contact8 = new Contact("Arthur Li88", "0674445675");


        ContactBook contactBook = new ContactBook();

        contactBook.addContact(contact1);
        contactBook.addContact(contact2);
        contactBook.addContact(contact3);
        contactBook.addContact(contact4);
        contactBook.addContact(contact5);
        contactBook.addContact(contact6);
        contactBook.addContact(contact7);
        contactBook.addContact(contact8);

//        System.out.println("Show First Five");
//        contactBook.showFirstFiveContacts();
        System.out.println("Show Last Five");
        contactBook.showLastFiveContacts();

      //  contactBook.findContactByName("Arthur");
     //   contactBook.removeLast();
//        contactBook.showAllContacts();
    }

}