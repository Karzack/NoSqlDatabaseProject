package beavercoffee.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPanel extends JPanel {
    private JPanel menuPanel = new JPanel();
    private JPanel menuLeft = new JPanel();
    private JPanel menuRight = new JPanel();
    private int height, width;
    private Button addCustomer = new Button("Add custommer");
    private Button addEmplyee = new Button("Add employee");
    private Button orders = new Button("orders");
    private Button addOrder = new Button("Add order");
    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JFrame frame3 = new JFrame();
    private JFrame frame4 = new JFrame();

    public MainPanel(int height, int width) {
        this.height = height;
        this.width = width;
        initGUI();
    }

    private void initGUI() {
        setPreferredSize(new Dimension(height, width));
        setLayout(new GridLayout(0,3));
        JLabel lblMenu = new JLabel("Welcome!", SwingConstants.CENTER);
        add(menuLeft);
        add(menuPanel);
        add(menuRight);
        menuPanel.add(lblMenu);
        menuLeft.add(addCustomer);
        menuLeft.add(addEmplyee);
        menuLeft.add(orders);
        menuLeft.add(addOrder);
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
        orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.getContentPane().add(new Orders(500,400));
                frame3.pack();
                frame3.setVisible(true);

            }
        });
        addOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame4.getContentPane().add(new AddOrder(500,400));
                frame4.pack();
                frame4.setVisible(true);

            }
        });
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}