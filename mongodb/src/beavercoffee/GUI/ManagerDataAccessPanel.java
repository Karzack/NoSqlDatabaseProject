package beavercoffee.GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagerDataAccessPanel extends JPanel {
    private JTextField tfSearch = new JTextField("Enter name");
    private JButton btnSearch = new JButton("Search");
    private JTextArea taInfo = new JTextArea("Your information will be displayed here");
    private JTextField tfName = new JTextField("Type name here");
    private JTextField tfAddress = new JTextField("Type address here");
    private JTextField tfID = new JTextField("Type ID,SSN or civic nr here");
    private JTextField tfQuantity = new JTextField("Type new quantity");
    private JButton btnCreate = new JButton("Create");
    private JButton btnUpdate = new JButton("Update");
    private JPanel btnPanel = new JPanel();
    private String[] availableSelection = {"Customers", "Employee", "Products" };
    private JComboBox<String> selection = new JComboBox<String>(availableSelection);
    private JTextField tfOccupation = new JTextField("Type customer occupation here");
    private JPanel pnlTop = new JPanel();
    private int height, width;

    public ManagerDataAccessPanel(int height, int width) {
        this.height = height;
        this.width = width;
        initMDAPanel();
    }

    private void initMDAPanel() {
        setPreferredSize(new Dimension(width, height));
        taInfo.setPreferredSize(new Dimension(width, height/3));
        tfSearch.setPreferredSize(new Dimension(width/2, 30));
        btnSearch.setPreferredSize(new Dimension(120, 30));
        taInfo.setLineWrap(true);
        selection.setPreferredSize(new Dimension(width/2, 30));
        Dimension tfSize = new Dimension(width/2, 30);
        Dimension btnSize = new Dimension(120, 30);

        tfName.setPreferredSize(tfSize);
        tfAddress.setPreferredSize(tfSize);
        tfID.setPreferredSize(tfSize);
        btnCreate.setPreferredSize(btnSize);
        btnUpdate.setPreferredSize(btnSize);
        btnPanel.setPreferredSize(new Dimension(width, 40));
        tfOccupation.setPreferredSize(tfSize);
        tfQuantity.setPreferredSize(tfSize);

        pnlTop.add(selection);
        add(selection);
        add(tfSearch);
        add(btnSearch);
        add(taInfo);
    }

    public JComboBox<String> getSelection() {
        return selection;
    }

    public JButton getButton() {
        return btnSearch;
    }

    public String getName() {
        return tfSearch.getText();
    }

    public String[] getCustomerInfo() {
        return new String[]{tfName.getText(), tfID.getText(), tfAddress.getText(), tfOccupation.getText()};
    }

    public String[] getEmployeeInfo() {
        return new String[]{tfName.getText(), tfID.getText(), tfAddress.getText()};
    }

    public JButton[] getUpdateCreateButtons() {
        return new JButton[] {btnCreate, btnUpdate};
    }

    public void updateInfo(String info) {
        taInfo.setText(info);
    }

    public void drawCustomerTextFields() {
        remove(tfQuantity);
        btnCreate.setEnabled(true);
        add(tfName);
        add(tfAddress);
        add(tfID);
        add(tfOccupation);
        add(btnPanel);
        btnPanel.add(btnCreate);
        btnPanel.add(btnUpdate);
        revalidate();
        repaint();
    }

    public void drawEmployeeTextField() {
        remove(tfOccupation);
        remove(tfQuantity);
        btnCreate.setEnabled(true);
        add(tfAddress);
        add(tfID);
        add(btnPanel);
        btnPanel.add(btnCreate);
        btnPanel.add(btnUpdate);
        revalidate();
        repaint();
    }

    public void drawProductTextField() {
        remove(tfAddress);
        remove(tfID);
        remove(btnPanel);
        remove(tfOccupation);
        add(tfQuantity);
        add(btnPanel);
        btnCreate.setEnabled(false);
        revalidate();
        repaint();
    }
}
