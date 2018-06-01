package database.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * @author Ola Dahl
 */
public class ClubMember {
    private ObjectId id;
    private String name;
    private String SSN;
    private String address;
    private Date memberSince;
    private String occupation;
    private boolean hasBenefits;
    private List<Order> listOfOrders;
    private String cardNumber;

    public ClubMember() { }

    public ClubMember(String name, String SSN, String address, Date memberSince, String occupation, boolean hasBenefits, List<Order> listOfOrders, String cardNumber) {
        this.name = name;
        this.SSN = SSN;
        this.address = address;
        this.memberSince = memberSince;
        this.occupation = occupation;
        this.hasBenefits = hasBenefits;
        this.listOfOrders = listOfOrders;
        this.cardNumber = cardNumber;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    public boolean getHasBenefits() {
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
        return this.name;
    }
}
