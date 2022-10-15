package presentationlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController implements ActionListener {
    private Employee em;

    public EmployeeController(Employee em2){
        em = em2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
}
