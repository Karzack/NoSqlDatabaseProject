package database.model;

import java.util.Date;

public class Comment {
    private Employee issuer;
    private Employee issuee;
    private String comment;
    private Date entryDate;

    public Comment() {}

    public Comment(Employee issuer, Employee issuee, String comment, Date entryDate) {
        this.issuer = issuer;
        this.issuee = issuee;
        this.comment = comment;
        this.entryDate = entryDate;
    }

    public Employee getIssuer() {
        return issuer;
    }

    public void setIssuer(Employee issuer) {
        this.issuer = issuer;
    }

    public Employee getIssuee() {
        return issuee;
    }

    public void setIssuee(Employee issuee) {
        this.issuee = issuee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "issuer=" + issuer +
                ", issuee=" + issuee +
                ", comment='" + comment + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
