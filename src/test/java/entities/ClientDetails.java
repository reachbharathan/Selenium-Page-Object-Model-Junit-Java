package entities;

public class ClientDetails {

    private String contact;

    private String address;

    public ClientDetails(String contact, String address) {
        this.contact = contact;
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
}
