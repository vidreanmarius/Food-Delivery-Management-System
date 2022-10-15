package presentationlayer;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Employee extends JFrame implements Observer {
    private JPanel panel1;

    public Employee(){

        super("EmployeeWindow");
        setContentPane(panel1);
        setSize(750, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    EmployeeController employeeController = new EmployeeController(this);

    @Override
    public void update(Observable o, Object arg) {

    }
}
