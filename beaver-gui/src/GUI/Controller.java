package GUI;


import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.ClubMember;
import database.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.UUID;

public class Controller {

    public void onAddEmployee(String name, String ssn, String startDate, String endDate, String workingPercentage, String role) {
//        MongoCollection<Employee> collection = DBInstance.getInstance().getCollection("employees", Employee.class);
//        Employee employee = new Employee(
//                name,
//                ssn,
//                startDate,
//                endDate,
//                Integer.parseInt(workingPercentage),
//                role
//        );
//
//        collection.insertOne(employee);
    }

    public void onAddMember(String name, String ssn, String address, String occupation, boolean hasBenefit) {
        ClubMember member = new ClubMember(
                name,
                ssn,
                address,
                new Date(),
                occupation,
                hasBenefit,
                null,
                UUID.randomUUID().toString()
        );
    }

    public void onAddOrder() {

    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        JFrame frame = new JFrame();
        EventQueue.invokeLater(() -> {

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.getContentPane().add(new MainPanel(400,500, controller));
            frame.pack();
            frame.setVisible(true);

        });
    }

}
