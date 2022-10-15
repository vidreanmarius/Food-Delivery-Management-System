package presentationlayer;

import bll.DeliveryService;

import javax.swing.*;

public class RegisterWindow extends JFrame {
    private JPanel panel1;
    private JTextField username;
    private JTextField password;
    private JComboBox comboBox;
    private JButton registerButton;
    private JButton backButton;

    DeliveryService dv1;
    public RegisterWindow(DeliveryService dv){
        super("RegisterWindow");
        setContentPane(panel1);
        setSize(300, 310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        dv1 = dv;

        this.registerButton.addActionListener(registerWindowController);
        this.backButton.addActionListener(registerWindowController);

    }

    RegisterWindowController registerWindowController = new RegisterWindowController(this);

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public DeliveryService getDv1() {
        return dv1;
    }

    public void setDv1(DeliveryService dv1) {
        this.dv1 = dv1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public RegisterWindowController getRegisterWindowController() {
        return registerWindowController;
    }

    public void setRegisterWindowController(RegisterWindowController registerWindowController) {
        this.registerWindowController = registerWindowController;
    }
}
