import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void removeContact(Contact contact) {
        if (contacts.remove(contact)) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:\n" + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("All contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = sc.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    System.out.print("Enter name of contact to remove: ");
                    String removeName = sc.nextLine();
                    addressBook.searchContact(removeName);
                    break;
                case 3:
                    System.out.print("Enter name of contact to search: ");
                    String searchName = sc.nextLine();
                    addressBook.searchContact(searchName);
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    System.out.println("Please try again.");
            }
        }
    }
}