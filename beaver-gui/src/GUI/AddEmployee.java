package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEmployee extends JPanel{
    private int width, height;

    private JTextField tfName = new JTextField();
    private JTextField tfSSN = new JTextField();
    private JTextField tfStartDate = new JTextField();
    private JTextField tfEndDate = new JTextField();
    private JTextField workingP = new JTextField();
    private JTextField tfRole = new JTextField();

    private JButton btnEnter = new JButton("Add Employee");

    public AddEmployee(int width, int height){
        this.width = width;
        this.height = height;

        JLabel lblName = new JLabel("Employee name: ");
        JLabel lblSSN = new JLabel("Employee SSN: ");
        JLabel lblStartDate = new JLabel("Start date: ");
        JLabel lblEndDate = new JLabel("End date ");
        JLabel lblWP = new JLabel("Working procentge");
        JLabel lblRole = new JLabel("Role");

        lblName.setPreferredSize(new Dimension(130, 50));
        lblSSN.setPreferredSize(new Dimension(130, 50));
        lblStartDate.setPreferredSize(new Dimension(130, 50));
        lblEndDate.setPreferredSize(new Dimension(130, 50));
        lblWP.setPreferredSize(new Dimension(130, 50));
        lblRole.setPreferredSize(new Dimension(130, 50));

        tfName.setPreferredSize(new Dimension(250, 25));
        tfSSN.setPreferredSize(new Dimension(250, 25));
        tfStartDate.setPreferredSize(new Dimension(250, 25));
        tfEndDate.setPreferredSize(new Dimension(250, 25));
        workingP.setPreferredSize(new Dimension(250, 25));
        tfRole.setPreferredSize(new Dimension(250, 25));

        add(lblName);
        add(tfName);
        add(lblSSN);
        add(tfSSN);
        add(lblStartDate);
        add(tfStartDate);
        add(lblEndDate);
        add(tfEndDate);
        add(lblWP);
        add(workingP);
        add(lblRole);
        add(tfRole);

        add(btnEnter);

    }

    public JButton getBtnEnter(){
        return btnEnter;
    }

    public String[] getTextEmployeeData(){
        return new String[]{tfName.getText(), tfSSN.getText(), tfStartDate.getText(), tfEndDate.getText(), workingP.getText(),tfRole.getText()};
    }

    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }
}