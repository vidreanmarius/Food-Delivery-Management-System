package presentationlayer;

import bll.BaseProduct;
import bll.CompositeProduct;
import bll.MenuItem;
import datalayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class AdministratorController implements ActionListener {
    private Administrator ad;
    Serializator s = new Serializator();
    List<BaseProduct> toComposite = new LinkedList<>();

    public AdministratorController(Administrator ad2){
        ad = ad2;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == ad.getGenerateReportsButton()){
            ReportsWindow rw = new ReportsWindow(ad.dv1);
            ad.dispose();
        }

        if(source == ad.getShowSelectedProductButton()){
            DefaultTableModel model = (DefaultTableModel)ad.getTable1().getModel();
            int selectedRow = ad.getTable1().getSelectedRow();

            ad.getProductTitleTextField().setText(model.getValueAt(selectedRow, 0).toString());
            ad.getRatingTextField().setText(model.getValueAt(selectedRow, 1).toString());
            ad.getCaloriesTextField().setText(model.getValueAt(selectedRow, 2).toString());
            ad.getProteinsTextField().setText(model.getValueAt(selectedRow, 3).toString());
            ad.getFatsTextField().setText(model.getValueAt(selectedRow, 4).toString());
            ad.getSodiumTextField().setText(model.getValueAt(selectedRow, 5).toString());
            ad.getPriceTextField().setText(model.getValueAt(selectedRow, 6).toString());
        }

        if(source == ad.getAddToCompositeButton()){

            BaseProduct bp = new BaseProduct(ad.getProductTitleTextField().getText(), Double.parseDouble(ad.getRatingTextField().getText()),
                    Integer.parseInt(ad.getCaloriesTextField().getText()), Double.parseDouble(ad.getProteinsTextField().getText()),
                    Double.parseDouble(ad.getFatsTextField().getText()), Double.parseDouble(ad.getSodiumTextField().getText()), Double.parseDouble(ad.getPriceTextField().getText()));

            toComposite.add(bp);

            JTable table2 = ad.getTable2();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Title");
            model.addColumn("Rating");
            model.addColumn("Calories");
            model.addColumn("Proteins");
            model.addColumn("Fats");
            model.addColumn("Sodium");
            model.addColumn("Price");

            for(BaseProduct bp2: toComposite){
                Vector<Object> rowContent = new Vector<>();

                rowContent.add(bp2.getTitle());
                rowContent.add(bp2.getRating());
                rowContent.add(bp2.getCalories());
                rowContent.add(bp2.getProtein());
                rowContent.add(bp2.getFat());
                rowContent.add(bp2.getSodium());
                rowContent.add(bp2.getPrice());
                model.addRow(rowContent);
            }

            table2.setModel(model);

        }

        if(source == ad.getAddNewCompositeButton()){
            CompositeProduct compositeProduct = new CompositeProduct(ad.getTextField8().getText());
            compositeProduct.setProductList(toComposite);
            ad.dv1.compositeProducts.add(compositeProduct);

            JTable table2 = ad.getTable2();
            DefaultTableModel model = new DefaultTableModel();
            model.setRowCount(0);
            table2.setModel(model);

            try {
                s.serialize(ad.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            toComposite.clear();
        }

        if(source == ad.getModifyButton()){

            DefaultTableModel model = (DefaultTableModel)ad.getTable1().getModel();
            int selectedRow = ad.getTable1().getSelectedRow();

            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setTitle(ad.getProductTitleTextField().getText());
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setRating(Double.parseDouble(ad.getRatingTextField().getText()));
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setCalories(Integer.parseInt(ad.getCaloriesTextField().getText()));
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setProtein(Double.parseDouble(ad.getProteinsTextField().getText()));
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setFat(Double.parseDouble(ad.getFatsTextField().getText()));
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setSodium(Double.parseDouble(ad.getSodiumTextField().getText()));
            ad.dv1.findProduct2(model.getValueAt(selectedRow, 0).toString()).setPrice(Double.parseDouble(ad.getPriceTextField().getText()));

            try {
                s.serialize(ad.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(source == ad.getRemoveButton()){
            BaseProduct bp = new BaseProduct(ad.getProductTitleTextField().getText(), Double.parseDouble(ad.getRatingTextField().getText()),
                    Integer.parseInt(ad.getCaloriesTextField().getText()), Double.parseDouble(ad.getProteinsTextField().getText()),
                    Double.parseDouble(ad.getFatsTextField().getText()), Double.parseDouble(ad.getSodiumTextField().getText()), Double.parseDouble(ad.getPriceTextField().getText()));
            ad.dv1.menu.remove(ad.dv1.findProduct(bp));
            ad.dv1.realMenu.remove(ad.dv1.findProduct(bp));
            try {
                s.serialize(ad.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        if(source == ad.getAddBaseButton()){

            BaseProduct bp = new BaseProduct(ad.getProductTitleTextField().getText(), Double.parseDouble(ad.getRatingTextField().getText()),
                    Integer.parseInt(ad.getCaloriesTextField().getText()), Double.parseDouble(ad.getProteinsTextField().getText()),
                    Double.parseDouble(ad.getFatsTextField().getText()), Double.parseDouble(ad.getSodiumTextField().getText()), Double.parseDouble(ad.getPriceTextField().getText()));

            ad.dv1.menu.add(bp);
            ad.dv1.realMenu.add(bp);
            try {
                s.serialize(ad.dv1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }



        }

        if(source == ad.getImportButton()){
            try {
                ad.dv1 = s.deserialize();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            JTable table1 = ad.getTable1();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Title");
            model.addColumn("Rating");
            model.addColumn("Calories");
            model.addColumn("Proteins");
            model.addColumn("Fats");
            model.addColumn("Sodium");
            model.addColumn("Price");

            ad.dv1.realMenu.clear();
            ad.dv1.makeMenu();
            for(MenuItem mn: ad.dv1.realMenu){
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

/*


            for(BaseProduct bp: ad.dv1.menu){
                Vector<Object> rowContent = new Vector<>();

                rowContent.add(bp.getTitle());
                rowContent.add(bp.getRating());
                rowContent.add(bp.getCalories());
                rowContent.add(bp.getProtein());
                rowContent.add(bp.getFat());
                rowContent.add(bp.getSodium());
                rowContent.add(bp.getPrice());
                model.addRow(rowContent);
            }

            for(CompositeProduct cp: ad.dv1.compositeProducts){
                Vector<Object> rowContent = new Vector<>();

                rowContent.add(cp.getTitle());
                model.addRow(rowContent);
            }
*/
            table1.setModel(model);
        }
        if(source == ad.getBackButton()){
            StartWindow sw = new StartWindow(ad.dv1);
            ad.dispose();
        }
    }
}
