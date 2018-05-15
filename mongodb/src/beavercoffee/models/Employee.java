package beavercoffee.models;

import org.bson.codecs.DateCodec;
import org.bson.types.ObjectId;

import java.util.Date;

public class Employee {
    private ObjectId id;
    private String name;
    private String SSN;
    private Date startDate;
    private Date endDate;
    private int workingPercentage;
    private String role;

    public Employee() {}

    public Employee(String name, String SSN, Date startDate, Date endDate, int workingPercentage, String role) {
        this.name = name;
        this.SSN = SSN;
        this.startDate = startDate;
        this.endDate = endDate;
        this.workingPercentage = workingPercentage;
        this.role = role;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getWorkingPercentage() {
        return workingPercentage;
    }

    public void setWorkingPercentage(int workingPercentage) {
        this.workingPercentage = workingPercentage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SSN='" + SSN + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", workingPercentage=" + workingPercentage +
                ", role='" + role + '\'' +
                '}';
    }
}
