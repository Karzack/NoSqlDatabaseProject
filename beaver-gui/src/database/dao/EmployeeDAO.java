package database.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.DBInstance;
import database.model.Employee;

public class EmployeeDAO {
    private static final String EMPLOYEE_COLLECTION = "employees";
    public static void addEmployee(Employee employee) {
        MongoCollection<Employee> collection = DBInstance.connectDB().getCollection(EMPLOYEE_COLLECTION, Employee.class);
        collection.insertOne(employee);
    }

    public static Employee getEmployee(String ssn) {
        MongoCollection<Employee> collection = DBInstance.connectDB().getCollection(EMPLOYEE_COLLECTION, Employee.class);

        return collection.find(Filters.eq("sSN", ssn)).first();
    }
}
