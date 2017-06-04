package entities;

public class QuotationDetails {

    private String contact;
    private String address;
    private String eventDate;

    public QuotationDetails(String contact, String address, String eventDate) {
        this.contact = contact;
        this.address = address;
        this.eventDate = eventDate;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getEventDate() {
        return eventDate;
    }
}
