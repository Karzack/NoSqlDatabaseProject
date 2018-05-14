package beavercoffee.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Switcher extends JPanel {
    private HashMap<String, JPanel> panelMap = new HashMap<String, JPanel>();

    public Switcher(){
        this.setLayout(new CardLayout());
        init();
    }

    private void init(){

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
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 Switcher switcher = new Switcher();

                 frame.add(switcher);
                  frame.pack();
                  frame.setVisible(true);

            }
        });



}
}



