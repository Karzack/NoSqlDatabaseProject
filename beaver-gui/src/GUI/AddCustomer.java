package GUI;




import database.dao.ClubMemberDAO;
import database.model.ClubMember;

import java.awt.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.swing.*;

public class AddCustomer extends JPanel{
    private int width, height;

    private JTextField tfName = new JTextField();
    private JTextField tfID = new JTextField();
    private JTextField tfAddress = new JTextField();
    private JTextField tfOccupation = new JTextField();

    private Checkbox checkboxBenefits = new Checkbox();

    private JButton btnEnter = new JButton("Add customer");

    public AddCustomer(int width, int height){
        this.width = width;
        this.height = height;

        JLabel lblName = new JLabel("Customer name: ");
        JLabel lblID = new JLabel("Customer ID: ");
        JLabel lblAddress = new JLabel("Customer Address: ");
        JLabel lblOccupation = new JLabel("Customer Occupation: ");
        JLabel lblBenefits = new JLabel("Is employee?");

        lblName.setPreferredSize(new Dimension(130, 50));
        lblID.setPreferredSize(new Dimension(130, 50));
        lblAddress.setPreferredSize(new Dimension(130, 50));
        lblOccupation.setPreferredSize(new Dimension(130, 50));
        lblBenefits.setPreferredSize(new Dimension(130, 50));
        tfName.setPreferredSize(new Dimension(250, 25));
        tfID.setPreferredSize(new Dimension(250, 25));
        checkboxBenefits.setPreferredSize(new Dimension(250, 25));
        tfAddress.setPreferredSize(new Dimension(250, 25));
        tfOccupation.setPreferredSize(new Dimension(250, 25));

        add(lblName);
        add(tfName);
        add(lblID);
        add(tfID);
        add(lblAddress);
        add(tfAddress);
        add(lblOccupation);
        add(tfOccupation);
        add(lblBenefits);
        add(checkboxBenefits);

        add(btnEnter);

        btnEnter.addActionListener(l -> {
            ClubMember member = new ClubMember(
                    tfName.getText(),
                    tfID.getText(),
                    tfAddress.getText(),
                    new Date(),
                    tfOccupation.getText(),
                    checkboxBenefits.getState(),
                    Collections.emptyList(),
                    UUID.randomUUID().toString()
            );

            ClubMemberDAO.addMember(member);
        });


        checkboxBenefits.addItemListener(l -> {

        });
    }

    public JButton getBtnEnter(){
        return btnEnter;
    }

    public String[] getTextFieldData(){
        return new String[]{tfName.getText(), tfID.getText(), tfAddress.getText(), tfOccupation.getText()};
    }

    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }

}
