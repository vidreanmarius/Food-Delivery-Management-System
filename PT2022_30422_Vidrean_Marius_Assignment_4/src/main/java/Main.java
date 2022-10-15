import bll.BaseProduct;
import bll.DeliveryService;
import bll.MenuItem;
import datalayer.Serializator;
import model.User;
import model.UserType;
import presentationlayer.StartWindow;
import presentationlayer.StartWindowController;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeliveryService dv = new DeliveryService();
        Serializator s = new Serializator();
/*
        List<BaseProduct> menu;

        User u1 = new User("administrator", "marius", UserType.ADMINISTRATOR);
        User u2 = new User("employee", "marius", UserType.EMPLOYEE);
        User u3 = new User("client", "marius", UserType.CLIENT);
        dv.addUser(u1);
        dv.addUser(u2);
        dv.addUser(u3);
        menu = s.getData();
        dv.setMenu(menu);
        s.serialize(dv);
*/

        dv = s.deserialize();
        StartWindow sw = new StartWindow(dv);

        dv.printMenu();


    }
}
