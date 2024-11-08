import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private ArrayList<Contact> contacts = new ArrayList<>();
    public boolean addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getFirstName().equals(contact.getFirstName()) && c.getLastName().equals(contact.getLastName())) {
                return false;
            }
        }
        contacts.add(contact);
        return true;
    }
    public boolean deleteContact(String firstName, String lastName) {
        return contacts.removeIf(c -> c.getFirstName().equals(firstName) && c.getLastName().equals(lastName));
    }
    public Contact findContact(String firstName, String lastName) {
        for (Contact c : contacts) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }

    public Contact[] findContacts(String group) {
        ArrayList<Contact> groupContacts = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getGroup().equals(group)) {
                groupContacts.add(c);
            }
        }
        return groupContacts.isEmpty() ? null : groupContacts.toArray(new Contact[0]);
    }

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nMenu: 1=Add, 2=Delete, 3=Find, 4=Group, 5=All, 6=Exit: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) break;
            switch (choice) {
                case 1 -> {
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Group: ");
                    String group = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Country Code: ");
                    String countryCode = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Country: ");
                    String country = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();

                    Contact contact = new Contact(group, email, firstName, lastName,
                            new PhoneNumber(countryCode, number),
                            new Address(zip, country, city));
                    System.out.println(phoneBook.addContact(contact) ? "Added!" : "Already exists!");
                }
                case 2 -> {
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.println(phoneBook.deleteContact(firstName, lastName) ? "Deleted!" : "Not found!");
                }
                case 3 -> {
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    Contact contact = phoneBook.findContact(firstName, lastName);
                    System.out.println(contact != null ? "Found: " + contact : "Not found.");
                }
                case 4 -> {
                    System.out.print("Group: ");
                    String group = scanner.nextLine();
                    Contact[] groupContacts = phoneBook.findContacts(group);
                    if (groupContacts != null && groupContacts.length > 0) {
                        for (Contact c : groupContacts) System.out.println(c);
                    } else {
                        System.out.println("No contacts in this group.");
                    }
                }
                case 5 -> phoneBook.printContacts();
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Exiting...");
        scanner.close();
    }
}
