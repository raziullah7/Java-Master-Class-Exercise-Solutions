import java.util.HashSet;
import java.util.Set;

public class Contact {
    // members
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    // constructors
    public Contact(String name) {
        this(name, null);
    }
    public Contact(String name, String email) {
        this(name, email, 0);
    }
    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        // add email to hashset emails
        if (email != null) {
            emails.add(email);
        }
        // add phone to hashset phones
        if (phone > 0) {
            String p = String.valueOf(phone);
            // forming a phone number pattern
            p = "(%s) %s-%s".formatted(p.substring(0, 3), p.substring(3, 6), p.substring(6));
            phones.add(p);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContact(Contact contact) {
        // cloning the current object
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        // copying the emails and phones of the argument
        newContact.emails.addAll(emails);
        newContact.phones.addAll(phones);
        // returning the newContact
        return newContact;
    }

}
