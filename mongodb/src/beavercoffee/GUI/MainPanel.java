package beavercoffee.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainPanel extends JPanel {

    private int height, width;
    private JLabel label = new JLabel("Welcome");
    private JLabel label2 = new JLabel("Location");
    private JLabel label3 = new JLabel("Rolls");
    private JLabel label4 = new JLabel("SSN");
    private String[] location = new String[] {"Malmö", "Stockholm", "Chicago"};
    private String[] rolls = new String[] {"Employee", "Employer", "Manager"};
    private JComboBox comboBox = new JComboBox(location);
    private JComboBox rule = new JComboBox(rolls);
    private Button addCustomer = new Button("Add custommer");
    private Button addEmplyee = new Button("Add employee");
    private Button login = new Button("Log in");
    private JTextField textField = new JTextField();
    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JFrame frame3 = new JFrame();


    public MainPanel(int height, int width) {
        this.height = height;
        this.width = width;
        initGUI();
    }

    private void initGUI() {
        setPreferredSize(new Dimension(height, width));
        this.setLayout(null);
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(comboBox);
        this.add(textField);
        this.add(rule);
        this.add(login);
        this.add(addEmplyee);
        this.add(addCustomer);
        label.setBounds(180, 30, 80, 40);
        label2.setBounds(50, 50, 80, 40);
        label3.setBounds(50, 80, 80, 40);
        label4.setBounds(50, 120, 80, 40);
        comboBox.setBounds(120, 60, 180, 30);
        rule.setBounds(120, 90, 180, 30);
        textField.setBounds(120, 120, 180, 30);
        login.setBounds(150, 150, 120, 30);
        addEmplyee.setBounds(50, 180, 140, 30);
        addCustomer.setBounds(210, 180, 140, 30);



        addCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().add(new AddCustomer(500,400));
                frame.pack();
                frame.setVisible(true);

            }
        });
        addEmplyee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.getContentPane().add(new AddEmployee(500,400));
                frame2.pack();
                frame2.setVisible(true);

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }


}