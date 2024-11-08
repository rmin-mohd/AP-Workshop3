public class Contact {
    private String group;
    private String email;
    private String firstName;
    private String lastName;
    private PhoneNumber phoneNumber;
    private Address address;

    public Contact(String firstName, String lastName, String group, String email, PhoneNumber phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group != null ? group : "";
        this.email = email != null ? email : "";
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + firstName +
                "\nlastName: " + (lastName != null ? lastName : "") +
                "\nGroup: " + (group != null ? group : "") +
                "\nEmail: " + (email != null ? email : "") +
                "\nContact.PhoneNumber: " + (phoneNumber != null ? phoneNumber.toString() : "No Phone Number") +
                "\nContact.Address: " + (address != null ? address.toString() : "No Contact.Address");
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("+91", "912123456712");
        Address address = new Address("3719688377", "India", "New Delhi");
        Contact contact = new Contact("Minhal", "Raza", "Friends", "min.raza@example.com", phoneNumber, address);

        System.out.println(contact.toString());
    }

}
