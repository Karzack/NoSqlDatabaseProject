package helpers;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.Employee;

import java.util.Arrays;
import java.util.List;

public class AddEmployeesHelper {

    public static void addSampleEmployees() {
        MongoCollection<Employee> collection = DBInstance.connectDB().getCollection("employees", Employee.class);

        collection.drop();

        List<Employee> employees = Arrays.asList(
                new Employee(
                        "Employee 1",
                        "123456-1234",
                        "2017-05-06",
                        null,
                        100,
                        "Employee"
                ),
                new Employee(
                        "Employee 2",
                        "123456-2345",
                        "2017-05-13",
                        "2018-01-23",
                        70,
                        "Employee"
                ),
                new Employee(
                        "Employee 3",
                        "123456-3456",
                        "2017-01-02",
                        null,
                        100,
                        "Employer"
                )
        );

        collection.insertMany(employees);
    }
}
