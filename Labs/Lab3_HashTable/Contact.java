package Labs.Lab3_HashTable;

public class Contact {

    private String name;

    private String email;

    private String contactDetails;

    public Contact(String name, String email, String contactDetails) {
        this.name = name;
        this.email = email;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        if (this.name == null) {
            return null;
        } else {
            return this.name;
        }
    }

    public String getEmail() {
        if (this.email == null) {
            return "null";
        } else {
            return this.email;
        }
    }

    public String getContactDetails() {
        if (this.contactDetails == null) {
            return null;
        } else {
            return this.contactDetails;
        }
    }

    public String getAllInfo() {
        if (this.contactDetails == null || this.name == null || this.email == null) {
            return null;
        } else {
            return "*******" + '\n' + "Name: " + name + '\n' + "Email: " + email
                    + '\n' + "Contact Details: " + contactDetails + '\n' + "*******";
        }
    }
    public void setName(String newName){
        if (!newName.equals(name)){
            this.name = newName;
        }
    }

    public void setEmail(String newEmail) {
        if (!newEmail.equals(email)){
            this.email = newEmail;
        }
    }

    public void setContactDetails(String newContactDetails) {
        if (!newContactDetails.equals(contactDetails)){
            this.contactDetails = newContactDetails;
        }
    }
    @Override
    public int hashCode(){
        int result = 0;
        for (int i = 0; i < name.length(); i++) {
            result += name.charAt(i);
        }
        return result % 59;
    }
}
