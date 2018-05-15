package beavercoffee;

import beavercoffee.models.Employee;
import com.mongodb.client.MongoCollection;

public class Controller {

    public void onAddEmployee(String name, String ssn, String startDate, String endDate, String workingPercentage, String role) {
        MongoCollection<Employee> collection = DBInstance.getInstance().getCollection("employees", Employee.class);
        Employee employee = new Employee(
                name,
                ssn,
                startDate,
                endDate,
                Integer.parseInt(workingPercentage),
                role
        );

        collection.insertOne(employee);


    }
}
