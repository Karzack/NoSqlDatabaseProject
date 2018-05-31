package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EmployeePanel extends MainPanel {
    private JButton btnAddCustomer = new JButton("Add customer");
    private JButton btnNewOrder = new JButton("New order");
    private JButton btnUpdateOrder = new JButton("Update order");

    public EmployeePanel(int height, int width) {
        super(height, width);
        initEmployeeMenuGUI();
    }

    private void initEmployeeMenuGUI() {
        btnNewOrder.setPreferredSize(new Dimension(120, 20));
        btnUpdateOrder.setPreferredSize(new Dimension(120, 20));
        btnAddCustomer.setPreferredSize(new Dimension(120, 20));
//        getMenuPanel().add(btnNewOrder);
//        getMenuPanel().add(btnUpdateOrder);
//        getMenuPanel().add(btnAddCustomer);
    }

    public JButton[] getButtons(){
        return new JButton[]{btnAddCustomer, btnNewOrder, btnUpdateOrder};
    }

}