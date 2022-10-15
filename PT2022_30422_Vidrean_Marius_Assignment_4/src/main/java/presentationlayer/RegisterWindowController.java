package presentationlayer;

import datalayer.Serializator;
import model.User;
import model.UserType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterWindowController implements ActionListener {
   private RegisterWindow rw;

    public RegisterWindowController(RegisterWindow rw2){

        rw = rw2;
        rw.getComboBox().addItem("ADMINISTRATOR");
        rw.getComboBox().addItem("CLIENT");
        rw.getComboBox().addItem("EMPLOYEE");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Serializator s = new Serializator();

        if(source == rw.getBackButton()){
            StartWindow sw = new StartWindow(rw.dv1);
            rw.dispose();
        }


        if(source == rw.getRegisterButton()){
            UserType userType = null;
            Object o = rw.getComboBox().getSelectedItem();
            String userTypeString = o.toString();

            if(userTypeString.equals("ADMINISTRATOR")){
                userType = UserType.ADMINISTRATOR;
            }

            if(userTypeString.equals("CLIENT")){
                userType = UserType.CLIENT;
            }

            if(userTypeString.equals("EMPLOYEE")){
                userType = UserType.EMPLOYEE;
            }

            User u = new User(rw.getUsername().getText(), rw.getPassword().getText(), userType);
            rw.dv1.addUser(u);
            try {
                s.serialize(rw.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
