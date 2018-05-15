package beavercoffee;

import beavercoffee.GUI.AddCustomer;
import beavercoffee.models.Employee;
import beavercoffee.models.Location;
import com.mongodb.client.MongoCollection;

public class Main {

    public void insertEmployee(Employee employee) {
        MongoCollection<Employee> collection = DBInstance.getInstance().getCollection("employees", Employee.class);
        collection.insertOne(employee);
    }

    public void printEmployees() {
        MongoCollection<Employee> collection = DBInstance.getInstance().getCollection("employees", Employee.class);
        for (Employee empl : collection.find()) System.out.println(empl);
    }

    public void insertLocation(Location location) {
        MongoCollection<Location> collection = DBInstance.getInstance().getCollection("locations", Location.class);
        collection.insertOne(location);
    }

    public void printLocations() {
        MongoCollection<Location> collection = DBInstance.getInstance().getCollection("locations", Location.class);
        for(Location loc : collection.find()) System.out.println(loc);
    }

    public static void main(String[] args) {

        AddCustomer gui = new AddCustomer(400,5000);

/*       Main app = new Main();

        app.insertEmployee(
                new Employee(
                        "19911220-1234",
                        new Date(),
                        null,
                        75,
                        "employer"
                )
        );

        app.insertLocation(
                new Location(
                        "Malmö1",
                        "SEK",
                        "swedish"
                )
        );

        app.printEmployees();
        app.printLocations();*/
    }

}
