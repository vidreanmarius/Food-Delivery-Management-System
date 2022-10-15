package datalayer;

import bll.MenuItem;
import bll.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriterr {

    public void generateBill(Order order, LinkedList<MenuItem> list){
        try {
            FileWriter myWriter = new FileWriter("bill.txt");
            myWriter.write("You order is:");
            myWriter.write("\nClient name: "+ order.getU().getEmail());
            myWriter.write("\nProducts bought: ");
            for(MenuItem m : list ) {
                myWriter.write("\n" + m.getTitle());
            }
            myWriter.write("\nTotal price is: " + order.getPrice());
            myWriter.close();
            System.out.println("Successfully generated bill!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void generateReport1(int startHour, int endHour, List<Order> orders1){

        try {
           FileWriter writer = new FileWriter("Report1.txt");
            writer.write("Orders placed between " + startHour  +" and " + endHour + "\n");
            for(Order order : orders1) {
                writer.append( "\nClient: " + order.getU().getEmail()+"\nPlaced at: "+ order.getDate()
                        + "\nOrdered products:\n" + order.getList().toString() + "\nTotal: " + order.getPrice()+"\n");
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport2(int numberOfTimes, List<MenuItem> menu1){

        try {
            FileWriter writer = new FileWriter("Report2.txt");
            writer.write("Menu Items ordered more than " + numberOfTimes + "\n");
            for(MenuItem menu : menu1) {
                writer.append("\n Menu Title: " + menu.getTitle() + " ordered " + menu.numberOfTimesOrdered + " times\n");
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport3(int numberOfTime, int greaterPrice, List<Order> orders3 ){
          List<String> nameList = new ArrayList<>();
        try {
            FileWriter writer = new FileWriter("Report3.txt");
            writer.write("Clients that ordered more than " + numberOfTime +" of times" +"\n");
            for(Order order : orders3){
                nameList.add(order.getU().getEmail());
            }
            List<String> finalList = nameList.stream()
                            .distinct()
                                    .collect(Collectors.toList());

            for(String s: finalList){
                writer.append(s + "\n");
;            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport4(int day, int month, int year, List<MenuItem> menuList){

        try {
            FileWriter writer = new FileWriter("Report4.txt");
            writer.write("Menu Items ordered on: " + day+ "/" + month + "/" + year +" \n" );

        for(MenuItem m : menuList){
            writer.write(m.getTitle() + " ordered: "+ m.getNumberOfTimesOrdered() + " times \n");
        }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("Report 4 created!");
    }

    }

