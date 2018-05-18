package beavercoffee.GUI;

import beavercoffee.Controller;

import javax.swing.JButton;


public class EmployerPanel extends MainPanel{

    public EmployerPanel(int height, int width, Controller controller) {
        super(height, width, controller);
        initEmployerMenuGUI();
    }

    private void initEmployerMenuGUI() {
        JButton btnEmployeeInfo = new JButton("Employee info");
        getMenuPanel().add(btnEmployeeInfo);
    }

}
