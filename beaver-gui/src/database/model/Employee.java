package database.model;

import org.bson.types.ObjectId;

/**
 * @author Ola Dahl
 */
public class Employee {
    private ObjectId id;
    private String name;
    private String SSN;
    private String startDate;
    private String endDate;
    private int workingPercentage;
    private String role;

    public Employee() {}

    public Employee(String name, String SSN, String startDate, String endDate, int workingPercentage, String role) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
        return this.name;
    }
}
