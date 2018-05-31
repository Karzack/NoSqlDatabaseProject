package GUI;

import javax.swing.JButton;


public class EmployerPanel extends MainPanel{

    public EmployerPanel(int height, int width) {
        super(height, width);
        initEmployerMenuGUI();
    }

    private void initEmployerMenuGUI() {
        JButton btnEmployeeInfo = new JButton("Employee info");
//        getMenuPanel().add(btnEmployeeInfo);
    }

}
