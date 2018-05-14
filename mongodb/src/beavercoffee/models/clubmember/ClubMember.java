package beavercoffee.models.clubmember;

import beavercoffee.models.Order;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class ClubMember {
    private ObjectId id;
    private String SSN;
    private Address address;
    private Date memberSince;
    private String occupation;
    private boolean hasBenefits;
    private List<Order> listOfOrders;
    private String cardNumber;

    public ClubMember() { }

    public ClubMember(String SSN, Address address, Date memberSince, String occupation, boolean hasBenefits, List<Order> listOfOrders, String cardNumber) {
        this.SSN = SSN;
        this.address = address;
        this.memberSince = memberSince;
        this.occupation = occupation;
        this.hasBenefits = hasBenefits;
        this.listOfOrders = listOfOrders;
        this.cardNumber = cardNumber;
    }

    public ObjectId getId() {
        return id;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isHasBenefits() {
        return hasBenefits;
    }

    public void setHasBenefits(boolean hasBenefits) {
        this.hasBenefits = hasBenefits;
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(List<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "id=" + id +
                ", SSN='" + SSN + '\'' +
                ", address=" + address +
                ", memberSince=" + memberSince +
                ", occupation='" + occupation + '\'' +
                ", hasBenefits=" + hasBenefits +
                ", listOfOrders=" + listOfOrders +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
