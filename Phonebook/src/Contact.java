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

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name: " + firstName +
                "\nlastName: " + (lastName != null ? lastName : "") +
                "\nGroup: " + (group != null ? group : "") +
                "\nEmail: " + (email != null ? email : "") +
                "\nPhoneNumber: " + (phoneNumber != null ? phoneNumber.toString() : "No Phone Number") +
                "\nAddress: " + (address != null ? address.toString() : "No Address");
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("+91", "912123456712");
        Address address = new Address("3719688377", "India", "New Delhi");
        Contact contact = new Contact("Minhal", "Raza", "Friends", "min.raza@example.com", phoneNumber, address);
        System.out.println(contact.toString());
    }
}
