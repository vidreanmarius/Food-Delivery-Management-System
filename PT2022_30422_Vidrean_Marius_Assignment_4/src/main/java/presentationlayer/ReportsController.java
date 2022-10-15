package presentationlayer;

import datalayer.FileWriterr;

import java.awt.color.ICC_ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReportsController implements ActionListener {
    private ReportsWindow rw;
    public FileWriterr fileWriterr;

    public ReportsController(ReportsWindow rw2){
        rw = rw2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == rw.getBackButton()){
            Administrator a = new Administrator(rw.dv);
            rw.dispose();
        }

        if(source == rw.getGenerateReportButton()){

            if(rw.getCheckBox1().isSelected()){
                int startHour = Integer.parseInt(rw.getStartHourTextField().getText());
                int endHour = Integer.parseInt(rw.getEndHourTextField().getText());
                rw.dv.generateReport1(startHour, endHour);
                System.out.println("Report1 generated!");
            }

            if(rw.getCheckBox2().isSelected()){
                int numberOfTimes = Integer.parseInt(rw.getNumberOfTimesTextField().getText());
                rw.dv.generateReport2(numberOfTimes);
                System.out.println("Report2 generated");
            }

            if(rw.getCheckBox3().isSelected()){
                int numberOfTimes2 = Integer.parseInt(rw.getNumberOfTimes2TextField().getText());
                int greaterPrice = Integer.parseInt(rw.getValueHigherThanTextField().getText());
                rw.dv.generateReport3(numberOfTimes2, greaterPrice);
            }

            if(rw.getCheckBox4().isSelected()){
                int day = Integer.parseInt(rw.getDayTextField().getText());
                int month = Integer.parseInt(rw.getMonthTextField().getText());
                int year = Integer.parseInt(rw.getYearTextField().getText());
                rw.dv.generateReport4(day, month, year);
            }

        }
    }
}
