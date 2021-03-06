package GUI;

import com.mongodb.client.MongoDatabase;
import database.DBInstance;
import helpers.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Switcher extends JPanel {
    private HashMap<String, JPanel> panelMap = new HashMap<String, JPanel>();
    private static JFrame frame;

    public Switcher() {
        this.setLayout(new CardLayout());
        init();
    }

    private void init() {
        initData();
        AddCustomer addCustomer = new AddCustomer(300, 400);
        panelMap.put("AddCustomer", addCustomer);
        this.add(addCustomer, "AddCustomer");

        Orders ordrs = new Orders(500, 400);
        panelMap.put("Orders", ordrs);
        this.add(ordrs, "Orders");

        EmployerPanel employerPanel = new EmployerPanel(500, 400);
        panelMap.put("EmpoyerPanel", employerPanel);
        this.add(employerPanel, "EmployerPanel");

        EmployeePanel employeePanel = new EmployeePanel(500, 400);
        panelMap.put("EmployeePanel", employeePanel);
        this.add(employeePanel, "EmployeeMenu");

//        AddStockInformationHelper.addInitialStockInformation();
    }

    public void showCard(String name) {
        CardLayout cl = (CardLayout) this.getLayout();
        cl.show(this, name);
    }

    public JPanel getPanel(String panel) {
        return panelMap.get(panel);
    }

    public static void closeLogin() {
        frame.dispose();
    }

    private void initData() {
        MongoDatabase db = DBInstance.connectDB();
        int i = 0;
        for (Document document : db.listCollections()) {
            i++;
        }
        if (i == 0) {
            System.out.println("Adding initial data");
            AddStockInformationHelper.addInitialStockInformation();
            AddProductsHelper.addProducts();
            AddLocationsHelper.addLocations();
            AddMembersHelper.addSampleMembers();
            AddEmployeesHelper.addSampleEmployees();
        }

    }

    public static void main(String[] args) {

        frame = new JFrame();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Switcher switcher = new Switcher();

                frame.getContentPane().add(new MainPanel(400, 500));
                frame.pack();
                frame.setVisible(true);

            }
        });


    }
}



