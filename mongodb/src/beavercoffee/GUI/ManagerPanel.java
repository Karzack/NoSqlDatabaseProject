package beavercoffee.GUI;

import java.awt.Dimension;

import javax.swing.JButton;


public class ManagerPanel extends MainPanel{
    private JButton btnData = new JButton("Get data");

    public ManagerPanel(int height, int width) {
        super(height, width);
        initManagerMenuGUI();
    }

    private void initManagerMenuGUI() {
        btnData.setPreferredSize(new Dimension(120, 20));

        getMenuPanel().add(btnData);
    }

    public JButton getButton() {
        return btnData;
    }
}