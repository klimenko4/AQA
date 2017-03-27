package ua.kiev.prog.week1.contactlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ContactBook {
    // code to interface , so that you could change an implementation in the future ;
    // List - interface , implementations - LinkedList , ArrayList ;

    // private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private List<Contact> contacts = new ArrayList<>();

/*    public void addContact(Contact contact) {
        Objects.requireNonNull(contact);
        this.contacts.add(contact);
    }*/

    //  addContact can return a boolean type  --> it's good of terms of unit testing



    public boolean addContact(Contact contact) {

        if (Objects.nonNull(contact)) {
            contacts.add(contact);
            return true;
        }
        return false;
    }

    public int getSize() {
        System.out.println(this.contacts.size());
        return this.contacts.size();
    }

    // Code to interface  --> what means return a broader type ( interface) , rather than a concrete implementation ;
    //public List<Contact> getContacts()
    public List<Contact> getContacts() {
        return contacts;
    }

/*    public String findContactByName(String name) {
        String contact = "";
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactName().contains(name)) {
                contact = contacts.get(i).getContactName() + " " + contacts.get(i).getNumber();
                System.out.println(contact);
            }
        }
        return contact;
    }*/


    public Contact findContactByName(String name) {

        for (Contact contact : contacts) {
            if (contact.getContactName().equals(name)) return contact;
        }
        return null;
    }

    // Java 8 style  --> Optional is a container for both return values itself and null values ( if nothing has been found)
    // User of your API( your ContactBook class) doesn't catch a NullPointerException since Optional.empty() represent a notion of value absence;
    //https://www.quora.com/What-is-the-difference-between-null-and-optional-empty-in-Java8

    public Optional<Contact> findContactByNameJava8(String name) {

        for (Contact contact : contacts) {
            if (contact.getContactName().equals(name)) return Optional.of(contact);
        }
        return Optional.empty();
    }

    // check that the contacts isn't empty list before remove anythings , otherwise you'll get ArrayIndexOutOfBoundsException ( index = -1)
    public void removeLast() {
        this.contacts.remove(this.contacts.size() - 1);
    }

    // I'd name it "printAllContacts" but nevermind
    // Override a #toString method in Contact class
    public void showAllContacts() {
/*
        String contact = "";
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i).getContactName() + " " + contacts.get(i).getNumber();
            System.out.println(contact);
        }
        return contact;
    }
*/
        for(Contact contact : contacts){
            // once contact is passed on to System.out.println , toString method is called on the contact object under the hood( automatically)
            System.out.println(contact);
        }

    }


    public String showAllContactsWithStringBuilder() {

        StringBuilder sb = new StringBuilder();

        for(Contact contact : contacts){
            sb.append(contact);
        }
        return sb.toString();
    }

    public void showFirstFiveContacts() {

        if (contacts.size()<5) {
            showAllContacts();
        } else {
            for (int i = 0; i < 5; i++) {
                Contact contact = contacts.get(i);
                System.out.println(contact);
            }
        }

    }

    public void showLastFiveContacts() {
        if (contacts.size()<5) {
            showAllContacts();
        } else {
            for (int i = contacts.size()-5; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println(contact);
            }
        }
    }
}