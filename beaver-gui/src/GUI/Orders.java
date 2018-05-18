package GUI;

import javax.swing.*;
import java.awt.*;

public class Orders extends JPanel  {
    private int width, height;
    private JList<String> productList = new JList<String>();
    private JList<String> orderList = new JList<String>();
    private JScrollPane productPane = new JScrollPane(productList);
    private JScrollPane orderPane = new JScrollPane(orderList);
    private JLabel lblProduct = new JLabel("Select product:");
    private JLabel lblOrder = new JLabel("Order:");
    private JLabel lblFiller = new JLabel();
    private JButton btnAddProduct = new JButton("Add >>");
    private JButton btnRemoveProduct = new JButton("<< Remove");
    private JPanel panel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private JPanel lblPanel = new JPanel();
    private String isClicked;

    private JButton btnEnter = new JButton("Save");

    public Orders(int width, int height) {
        this.width = width;
        this.height = height;
        initGUIComponents();
    }

    private void initGUIComponents() {
        setPreferredSize(new Dimension(width, height));

        lblPanel.setLayout(new GridLayout(0, 3));
        add(lblPanel);

        lblProduct.setPreferredSize(new Dimension(width/3, height/8));
        lblOrder.setPreferredSize(new Dimension(width/3, height/8));
        lblPanel.add(lblProduct);
        lblPanel.add(lblFiller);
        lblPanel.add(lblOrder);

        panel.setLayout(new GridLayout(0,3));
        add(panel);


        productPane.setPreferredSize(new Dimension((width/3),(height/2)));
        orderPane.setPreferredSize(new Dimension((width/3),(height/2)));
        btnAddProduct.setPreferredSize(new Dimension(50, 20));
        btnRemoveProduct.setPreferredSize(new Dimension(50, 20));
        btnPanel.setLayout(new BorderLayout());
        panel.add(productPane);
        panel.add(btnPanel);
        btnPanel.add(btnAddProduct, BorderLayout.NORTH);
        btnPanel.add(btnRemoveProduct, BorderLayout.SOUTH);
        panel.add(orderPane);

        add(btnEnter);



    }

    public JButton getBtnEnter(){

        return btnEnter;
    }



    public String getText(){
        return isClicked;
    }
}
