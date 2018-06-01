package GUI;

import com.sun.javafx.application.PlatformImpl;
import database.dao.EmployeeDAO;
import database.dao.LocationDAO;
import database.model.Employee;
import database.model.Location;
import helpers.AddLocationsHelper;
import helpers.AddProductsHelper;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import orderwindow.OrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainPanel extends JPanel {

    private int height, width;
    private JLabel label = new JLabel("Welcome");
    private JLabel label2 = new JLabel("Location");
    private JLabel label4 = new JLabel("SSN");
    private String[] location = new String[]{"Malmö", "Stockholm", "Chicago"};
    private JComboBox locationsCombo = new JComboBox(location);
    private Button addCustomer = new Button("Add customer");
    private Button addEmplyee = new Button("Add employee");
    private Button login = new Button("Log in");
    private JTextField txtSSN = new JTextField();
    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JFrame frame3 = new JFrame();

    private String locationName = "Malmö";

    public MainPanel(int height, int width) {
        this.height = height;
        this.width = width;
//        AddProductsHelper.addProducts();
//        AddLocationsHelper.addLocations();
        initGUI();
    }

    private void initGUI() {
        setPreferredSize(new Dimension(height, width));
        this.setLayout(null);
        this.add(label);
        this.add(label2);
        this.add(label4);
        this.add(locationsCombo);
        this.add(txtSSN);
        this.add(login);
        this.add(addEmplyee);
        this.add(addCustomer);
        label.setBounds(180, 30, 80, 40);
        label2.setBounds(50, 50, 80, 40);
        label4.setBounds(50, 120, 80, 40);
        locationsCombo.setBounds(120, 60, 180, 30);
        txtSSN.setBounds(120, 120, 180, 30);
        login.setBounds(150, 150, 120, 30);
        addEmplyee.setBounds(50, 180, 140, 30);
        addCustomer.setBounds(210, 180, 140, 30);


        addCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().add(new AddCustomer(500, 400));
                frame.pack();
                frame.setVisible(true);

            }
        });

        addEmplyee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.getContentPane().add(new AddEmployee(500, 400));
                frame2.pack();
                frame2.setVisible(true);

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = EmployeeDAO.getEmployee(txtSSN.getText());
                Location location = LocationDAO.getLocationByName(locationName);
                OrderController controller = new OrderController(employee, location);

                JFXPanel jfxPanel = new JFXPanel();

                if (employee != null) {
                    PlatformImpl.startup(() -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("../orderwindow/order_gui.fxml"));
                            loader.setController(controller);
                            Parent root = loader.load();
                            Scene scene = new Scene(root, 500, 575);

                            jfxPanel.setScene(scene);
                            frame3.getContentPane().add(jfxPanel);
                            frame3.pack();
                            frame3.setVisible(true);

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                }
            }
        });

        locationsCombo.addItemListener(e -> locationName = (String)e.getItem());
    }


}