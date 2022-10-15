package presentationlayer;

import bll.DeliveryService;
import model.User;
import model.UserType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class StartWindowController implements ActionListener {
    private StartWindow sw;

    public StartWindowController(StartWindow sw2){
        sw = sw2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == sw.getButtonRegister()){
            RegisterWindow rw = new RegisterWindow(sw.dv1);
            sw.dispose();
        }
        if(source == sw.getButtonLogin()){
            //if login
           /* DeliveryService dv = null;
            try {
                dv = new DeliveryService();
            } catch (IOException ex) {
                ex.printStackTrace();
            } */
            User u = sw.dv1.findUser(sw.getUsernameField().getText());
            if(u == null || !Arrays.equals(u.getPassword(), sw.getPasswordField().getPassword())){
                //here you pop an alert
                JOptionPane.showMessageDialog(null, "Username/Password incorrect!");
            }else {
                if (u.getUserType() == UserType.ADMINISTRATOR) {
                    Administrator ad = new Administrator(sw.dv1);
                    sw.dispose();
                }
                if (u.getUserType() == UserType.CLIENT) {
                    Client cl = new Client(sw.dv1, u);
                    sw.dispose();
                }
                if (u.getUserType() == UserType.EMPLOYEE) {
                    Employee ey = new Employee();
                    sw.dispose();
                }
            }
        }
    }
}
