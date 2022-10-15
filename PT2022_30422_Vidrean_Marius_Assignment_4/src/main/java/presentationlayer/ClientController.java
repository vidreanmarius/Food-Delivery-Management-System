package presentationlayer;

import bll.MenuItem;
import bll.Order;
import datalayer.FileWriterr;
import datalayer.Serializator;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ClientController implements ActionListener {
    private Client cl;

    Serializator s = new Serializator();
    FileWriterr fw = new FileWriterr();
    LinkedList<MenuItem> menuItemList0 = new LinkedList<>();


    public ClientController(Client cl2){
        cl = cl2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();


        if(source == cl.getGenerateOrderButton()){
            LocalDateTime localDateTime;
            User u = cl.u;
            u.numberOfTimesOrdered++;
            Order o = new Order(u, menuItemList0 );
            cl.dv1.orders.put(o, menuItemList0);

           for(MenuItem m: cl.dv1.orders.get(o)){
               o.setCalories(o.getCalories() + m.getCalories());
               o.setFat(o.getFat() + m.getFat());
               o.setPrice(o.getPrice() + m.getPrice());
               o.setProtein(o.getProtein() + m.getProtein());
               o.setSodium(o.getSodium() + m.getSodium());
           }
           fw.generateBill(o, menuItemList0);
            try {
                s.serialize(cl.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        if(source == cl.getAddToOrderButton()){
            DefaultTableModel model = (DefaultTableModel)cl.getTable1().getModel();
            int selectedRow = cl.getTable1().getSelectedRow();

            MenuItem mn = new MenuItem(model.getValueAt(selectedRow, 0).toString(), Double.parseDouble(model.getValueAt(selectedRow, 1).toString()),
                    Integer.parseInt(model.getValueAt(selectedRow, 2).toString()), Double.parseDouble(model.getValueAt(selectedRow, 3).toString()),
                    Double.parseDouble(model.getValueAt(selectedRow, 4).toString()),
                    Double.parseDouble(model.getValueAt(selectedRow, 5).toString()), Double.parseDouble(model.getValueAt(selectedRow, 6).toString()));
            cl.dv1.increaseOrderedTimes(mn);
          menuItemList0.add(mn);

        }

        if(source == cl.getBackButton()){
            StartWindow st = new StartWindow(cl.dv1);
            cl.dispose();
        }

        if(source == cl.getSearchButton()){
            try {
                cl.dv1 = s.deserialize();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            cl.dv1.makeMenu();
            List<MenuItem> menuItemList = new ArrayList<>();
            menuItemList.addAll(cl.dv1.realMenu);

            if(!cl.getTitleTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> !m.getTitle().contains(cl.getTitleTextField().getText()));
            }

            if(!cl.getRatingTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getRating() != Double.parseDouble(cl.getRatingTextField().getText()));
            }

            if(!cl.getCaloriesTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getCalories() != Double.parseDouble(cl.getCaloriesTextField().getText()));
            }

            if(!cl.getProteinsTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getProtein() != Double.parseDouble(cl.getProteinsTextField().getText()));
            }

            if(!cl.getFatTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getFat() != Double.parseDouble(cl.getFatTextField().getText()));
            }

            if(!cl.getSodiumTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getSodium() != Double.parseDouble(cl.getSodiumTextField().getText()));
            }

            if(!cl.getPriceTextField().getText().isEmpty()){
                menuItemList.removeIf(m -> m.getPrice() != Double.parseDouble(cl.getPriceTextField().getText()));
            }


            JTable table1 = cl.getTable1();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Title");
            model.addColumn("Rating");
            model.addColumn("Calories");
            model.addColumn("Proteins");
            model.addColumn("Fats");
            model.addColumn("Sodium");
            model.addColumn("Price");

            for(MenuItem mn: menuItemList){
                Vector<Object> rowContent = new Vector<>();

                rowContent.add(mn.getTitle());
                rowContent.add(mn.getRating());
                rowContent.add(mn.getCalories());
                rowContent.add(mn.getProtein());
                rowContent.add(mn.getFat());
                rowContent.add(mn.getSodium());
                rowContent.add(mn.getPrice());
                model.addRow(rowContent);
            }

            table1.setModel(model);
        }
    }
}
