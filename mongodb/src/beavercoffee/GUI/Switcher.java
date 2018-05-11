package beavercoffee.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Switcher extends JPanel {
    private HashMap<String, JPanel> panelMap = new HashMap<String, JPanel>();

    public Switcher(){
        this.setLayout(new CardLayout());
        init();
    }

    private void init(){

        Orders employerdMenu = new Orders(500, 400);
        panelMap.put("EmpoyerMenu", employerdMenu);
        this.add(employerdMenu, "EmployerMenu");

        EmployerPanel employerMenu = new EmployerPanel(500, 400);
        panelMap.put("EmpoyerMenu", employerMenu);
        this.add(employerMenu, "EmployerMenu");

        EmployeePanel employeePanel = new EmployeePanel(500, 400);
        panelMap.put("EmployeePanel", employeePanel);
        this.add(employeePanel, "EmployeeMenu");

        ManagerDataAccessPanel managerData = new ManagerDataAccessPanel(500, 400);
        panelMap.put("ManagerData", managerData);
        this.add(managerData, "ManagerData");

       ManagerPanel managerMenu = new ManagerPanel(500, 400);
        panelMap.put("ManagerMenu", managerMenu);
        this.add(managerMenu, "ManagerMenu");


        AddCustomer createCustomer = new AddCustomer(300, 400);
        panelMap.put("CreateCustomer", createCustomer);
        this.add(createCustomer, "CreateCustomer");

    }

    public void showCard(String name){
        CardLayout cl = (CardLayout)this.getLayout();
        cl.show(this, name);
    }

    public JPanel getPanel(String panel){
        return panelMap.get(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Switcher switcher = new Switcher();

        frame.add(switcher);
        frame.pack();
        frame.setVisible(true);
    }
    }