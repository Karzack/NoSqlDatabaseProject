package GUI;


import javax.swing.*;
import java.awt.*;

public class AddOrder extends JPanel{
    private int width, height;
    private JTextField[] tfQuantities;
    private JLabel[] lbls;
    private JButton btnEnter = new JButton("Add Order");
    private int i;

    public AddOrder(int width, int height){
        this.width = width;
        this.height = height;

        JLabel lblProducts = new JLabel("Products");
        lblProducts.setPreferredSize(new Dimension(200, 25));
        JLabel lblQuantities = new JLabel("Quantity");
        lblQuantities.setPreferredSize(new Dimension(200, 25));

        add(lblProducts);
        add(lblQuantities);

        String[] products = {"Espresso Roast", "Whole Bean French Roast", "Whole Bean Light Roast", "Brewed Coffee",
                "Espresso", "Cappucino", "Latte", "Hot Chocolate"};

        lbls = new JLabel[products.length];
        tfQuantities = new JTextField[products.length];

        for( i=0; i<products.length; i++){
            lbls[i] = new JLabel(products[i]);
            lbls[i].setPreferredSize(new Dimension(300, 25));
            tfQuantities[i] = new JTextField("0");
            tfQuantities[i].setPreferredSize(new Dimension(150, 25));
            add(lbls[i]);
            add(tfQuantities[i]);
            add(btnEnter);
        }
    }
    public JButton getBtnEnter(){
        return btnEnter;
    }

    public String[] getTextAddOrder(){
        return new String[]{tfQuantities[i].getText()};
    }

    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }

}