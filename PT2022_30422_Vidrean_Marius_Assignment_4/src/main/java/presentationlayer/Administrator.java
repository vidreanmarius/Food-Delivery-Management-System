package presentationlayer;

import bll.DeliveryService;

import javax.swing.*;

public class Administrator extends JFrame {

    private JPanel panel1;
    private JTable table1;
    private JButton importButton;
    private JTextField productTitleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinsTextField;
    private JTextField fatsTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JButton addBaseButton;
    private JButton removeButton;
    private JButton modifyButton;
    private JButton addNewCompositeButton;
    private JTable table2;
    private JTextField textField8;
    private JButton addToCompositeButton;
    private JButton backButton;
    private JButton generateReportsButton;
    private JButton showSelectedProductButton;

    DeliveryService dv1;

    public Administrator(DeliveryService dv2){
        super("AdministratorWindow");
        setContentPane(panel1);
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        dv1 = dv2;
        this.backButton.addActionListener(ac);
        this.importButton.addActionListener(ac);
        this.showSelectedProductButton.addActionListener(ac);
        this.addBaseButton.addActionListener(ac);
        this.removeButton.addActionListener(ac);
        this.modifyButton.addActionListener(ac);
        this.addToCompositeButton.addActionListener(ac);
        this.addNewCompositeButton.addActionListener(ac);
        this.generateReportsButton.addActionListener(ac);

    }

    AdministratorController ac = new AdministratorController(this);

    public JButton getShowSelectedProductButton() {
        return showSelectedProductButton;
    }

    public void setShowSelectedProductButton(JButton showSelectedProductButton) {
        this.showSelectedProductButton = showSelectedProductButton;
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

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getImportButton() {
        return importButton;
    }

    public void setImportButton(JButton importButton) {
        this.importButton = importButton;
    }

    public JTextField getProductTitleTextField() {
        return productTitleTextField;
    }

    public void setProductTitleTextField(JTextField productTitleTextField) {
        this.productTitleTextField = productTitleTextField;
    }

    public JTextField getRatingTextField() {
        return ratingTextField;
    }

    public void setRatingTextField(JTextField ratingTextField) {
        this.ratingTextField = ratingTextField;
    }

    public JTextField getCaloriesTextField() {
        return caloriesTextField;
    }

    public void setCaloriesTextField(JTextField caloriesTextField) {
        this.caloriesTextField = caloriesTextField;
    }

    public JTextField getProteinsTextField() {
        return proteinsTextField;
    }

    public void setProteinsTextField(JTextField proteinsTextField) {
        this.proteinsTextField = proteinsTextField;
    }

    public JTextField getFatsTextField() {
        return fatsTextField;
    }

    public void setFatsTextField(JTextField fatsTextField) {
        this.fatsTextField = fatsTextField;
    }

    public JTextField getSodiumTextField() {
        return sodiumTextField;
    }

    public void setSodiumTextField(JTextField sodiumTextField) {
        this.sodiumTextField = sodiumTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public JButton getAddBaseButton() {
        return addBaseButton;
    }

    public void setAddBaseButton(JButton addBaseButton) {
        this.addBaseButton = addBaseButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(JButton removeButton) {
        this.removeButton = removeButton;
    }

    public JButton getModifyButton() {
        return modifyButton;
    }

    public void setModifyButton(JButton modifyButton) {
        this.modifyButton = modifyButton;
    }

    public JButton getAddNewCompositeButton() {
        return addNewCompositeButton;
    }

    public void setAddNewCompositeButton(JButton addNewCompositeButton) {
        this.addNewCompositeButton = addNewCompositeButton;
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }

    public JTextField getTextField8() {
        return textField8;
    }

    public void setTextField8(JTextField textField8) {
        this.textField8 = textField8;
    }

    public JButton getAddToCompositeButton() {
        return addToCompositeButton;
    }

    public void setAddToCompositeButton(JButton addToCompositeButton) {
        this.addToCompositeButton = addToCompositeButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getGenerateReportsButton() {
        return generateReportsButton;
    }

    public void setGenerateReportsButton(JButton generateReportsButton) {
        this.generateReportsButton = generateReportsButton;
    }

    public AdministratorController getAc() {
        return ac;
    }

    public void setAc(AdministratorController ac) {
        this.ac = ac;
    }
}
