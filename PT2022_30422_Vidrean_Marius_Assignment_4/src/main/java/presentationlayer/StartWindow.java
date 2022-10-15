package presentationlayer;

import bll.DeliveryService;

import javax.swing.*;

public class StartWindow extends JFrame{
    private JLabel logInLabel;
    private JTextField usernameField;
    private JButton buttonRegister;
    private JPasswordField passwordField;
    private JPanel panel1;
    private JButton buttonLogin;

    DeliveryService dv1;

    public StartWindow(DeliveryService dv){
        super("StartWindow");
        setContentPane(panel1);
        setSize(300, 310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        dv1 = dv;

        //add action listener part
        this.buttonRegister.addActionListener(this.startWindowController);
        this.buttonLogin.addActionListener(this.startWindowController);
    }

    StartWindowController startWindowController = new StartWindowController(this);

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(JButton buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public JLabel getLogInLabel() {
        return logInLabel;
    }

    public void setLogInLabel(JLabel logInLabel) {
        this.logInLabel = logInLabel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JButton getButtonRegister() {
        return buttonRegister;
    }

    public void setButtonRegister(JButton buttonRegister) {
        this.buttonRegister = buttonRegister;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public StartWindowController getStartWindowController() {
        return startWindowController;
    }

    public void setStartWindowController(StartWindowController startWindowController) {
        this.startWindowController = startWindowController;
    }
}
