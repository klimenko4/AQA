package ua.kiev.prog.week1.contactlist;

public class Contact {

    private String contactName;
    private String number;

    // Check that input arguments not null and not empty,  validation can be put into the setters
    public Contact(String contactName, String number) {
        this.contactName = contactName;
       // setContactName(contactName);
        this.number = number;
    }

    public String getContactName() {
        return contactName;
    }

    public String getNumber() {
        return number;
    }


    public void setContactName(String contactName) {

        if (contactName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        //Objects.requireNonNull(contactName);  --> will throw NullPointerException if the argument is of a null type
        if (contactName == null) {
            throw new NullPointerException();
        }
        this.contactName = contactName;
    }

    // the same here
    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("contactName='").append(contactName).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}