package presentationlayer;

import bll.DeliveryService;
import model.User;

import javax.swing.*;

public class Client extends JFrame {
    private JPanel panel1;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinsTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JButton searchButton;
    private JTable table1;
    private JButton addToOrderButton;
    private JButton generateOrderButton;
    private JButton backButton;

    public DeliveryService dv1;
    public User u;

    public Client(DeliveryService dv, User u){
        super("ClientWindow");
        setContentPane(panel1);
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        dv1 = dv;
        this.u = u;

        this.searchButton.addActionListener(clientController);
        this.backButton.addActionListener(clientController);
        this.addToOrderButton.addActionListener(clientController);
        this.generateOrderButton.addActionListener(clientController);
    }

    ClientController clientController = new ClientController(this);

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(JTextField titleTextField) {
        this.titleTextField = titleTextField;
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

    public JTextField getFatTextField() {
        return fatTextField;
    }

    public void setFatTextField(JTextField fatTextField) {
        this.fatTextField = fatTextField;
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

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getAddToOrderButton() {
        return addToOrderButton;
    }

    public void setAddToOrderButton(JButton addToOrderButton) {
        this.addToOrderButton = addToOrderButton;
    }

    public JButton getGenerateOrderButton() {
        return generateOrderButton;
    }

    public void setGenerateOrderButton(JButton generateOrderButton) {
        this.generateOrderButton = generateOrderButton;
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }
}
