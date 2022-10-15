package presentationlayer;

import bll.DeliveryService;

import javax.swing.*;

public class ReportsWindow extends JFrame {

    private JPanel panel1;
    private JTextField endHourTextField;
    private JTextField numberOfTimesTextField;
    private JTextField valueHigherThanTextField;
    private JTextField numberOfTimes2TextField;
    private JTextField startHourTextField;
    private JTextField monthTextField;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JButton generateReportButton;
    private JTextField yearTextField;
    private JTextField dayTextField;
    private JButton backButton;
    public DeliveryService dv;

    public ReportsWindow(DeliveryService dv){
        super("ReportsWindow");
        setContentPane(panel1);
        setSize(800, 310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.dv = dv;

        generateReportButton.addActionListener(reportsController);
        backButton.addActionListener(reportsController);

    }

    ReportsController reportsController = new ReportsController(this);

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getEndHourTextField() {
        return endHourTextField;
    }

    public void setEndHourTextField(JTextField endHourTextField) {
        this.endHourTextField = endHourTextField;
    }

    public JTextField getNumberOfTimesTextField() {
        return numberOfTimesTextField;
    }

    public void setNumberOfTimesTextField(JTextField numberOfTimesTextField) {
        this.numberOfTimesTextField = numberOfTimesTextField;
    }

    public JTextField getValueHigherThanTextField() {
        return valueHigherThanTextField;
    }

    public void setValueHigherThanTextField(JTextField valueHigherThanTextField) {
        this.valueHigherThanTextField = valueHigherThanTextField;
    }

    public JTextField getNumberOfTimes2TextField() {
        return numberOfTimes2TextField;
    }

    public void setNumberOfTimes2TextField(JTextField numberOfTimes2TextField) {
        this.numberOfTimes2TextField = numberOfTimes2TextField;
    }

    public JTextField getStartHourTextField() {
        return startHourTextField;
    }

    public void setStartHourTextField(JTextField startHourTextField) {
        this.startHourTextField = startHourTextField;
    }

    public JTextField getDayTextField() {
        return dayTextField;
    }

    public void setDayTextField(JTextField dayTextField) {
        this.dayTextField = dayTextField;
    }

    public JCheckBox getCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(JCheckBox checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public JCheckBox getCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(JCheckBox checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public JCheckBox getCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(JCheckBox checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public JCheckBox getCheckBox4() {
        return checkBox4;
    }

    public void setCheckBox4(JCheckBox checkBox4) {
        this.checkBox4 = checkBox4;
    }

    public JButton getGenerateReportButton() {
        return generateReportButton;
    }

    public void setGenerateReportButton(JButton generateReportButton) {
        this.generateReportButton = generateReportButton;
    }

    public ReportsController getReportsController() {
        return reportsController;
    }

    public void setReportsController(ReportsController reportsController) {
        this.reportsController = reportsController;
    }

    public JTextField getMonthTextField() {
        return monthTextField;
    }

    public void setMonthTextField(JTextField monthTextField) {
        this.monthTextField = monthTextField;
    }

    public JTextField getYearTextField() {
        return yearTextField;
    }

    public void setYearTextField(JTextField yearTextField) {
        this.yearTextField = yearTextField;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public DeliveryService getDv() {
        return dv;
    }

    public void setDv(DeliveryService dv) {
        this.dv = dv;
    }
}
