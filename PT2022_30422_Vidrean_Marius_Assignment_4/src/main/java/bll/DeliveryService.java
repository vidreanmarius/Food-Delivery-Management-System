package bll;

import datalayer.FileWriterr;
import datalayer.Serializator;
import model.User;
import model.UserType;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {

    private static final long serialVersionUID = 1234567L;

    public Map<Order, LinkedList<MenuItem>> orders;
    public List<MenuItem>realMenu;
    public List<BaseProduct> menu;
    public List<CompositeProduct> compositeProducts;
    public List<User> users;


    public DeliveryService() throws IOException {

        orders = new HashMap<>();
        menu = new LinkedList<>();
        users = new ArrayList<>();
        compositeProducts = new LinkedList<>();
        realMenu = new LinkedList<>();

    }

    public void generateReport1(int startHour, int endHour) {

        List<Order> orders1 = orders.keySet()
                .stream()

                .filter(order -> {
                    int hour = order.getDate().getHour();
                    return hour >= startHour && hour <= endHour; })
                .collect(Collectors.toList());
        FileWriterr fileWriterr = new FileWriterr();
        fileWriterr.generateReport1(startHour, endHour, orders1);
    }

    public void generateReport2(int numberOfTimes){
        List<MenuItem> menuItemList = realMenu.stream()
                .filter(menuItem -> menuItem.getNumberOfTimesOrdered() >= numberOfTimes)
                .collect(Collectors.toList());
        FileWriterr fileWriterr = new FileWriterr();

        fileWriterr.generateReport2(numberOfTimes, menuItemList);
    }

    public void generateReport3(int numberOfTime, int greaterPrice){
        List<Order> orders3 = orders.keySet()
                .stream()
                .filter(order->order.getU().numberOfTimesOrdered >numberOfTime
                 && order.getPrice() > greaterPrice)
                .collect(Collectors.toList());

        FileWriterr fileWriterr = new FileWriterr();

        fileWriterr.generateReport3(numberOfTime, greaterPrice, orders3);
    }

    public void generateReport4(int day, int month, int year){

        List<Order> order4 = orders.keySet()
                .stream()
                .filter(order -> order.getDate().getDayOfMonth() == day && order.getDate().getMonthValue() == month && order.getDate().getYear() == year)
                .collect(Collectors.toList());

        List<MenuItem> menuList = new ArrayList<>();
        for(Order o : order4){
            menuList.addAll(o.getList());
        }
        List<MenuItem> preFinalList = new ArrayList<>();
        for(MenuItem m : menuList){
            preFinalList.add(findMenuItem(m));
        }

        List<MenuItem>finalFinalList = preFinalList.stream()
                .distinct()
                .collect(Collectors.toList());

        FileWriterr fileWriterr = new FileWriterr();
        fileWriterr.generateReport4(day, month, year, finalFinalList);
    }


    public void makeMenu(){
        realMenu.addAll(menu);

        realMenu.addAll(compositeProducts);
    }

    public void printMenu(){
        for(BaseProduct b : menu){
            System.out.println(b.getTitle() + "\n" + b.getCalories());
        }
    }

    public void addUser(User u){
        users.add(u);
    }

    public void setMenu(List<BaseProduct> menu){
        this.menu = menu;
    }

    public void printUser(){
        for(User u : users){
            System.out.println(u.getEmail());
        }
    }

    public BaseProduct findProduct(BaseProduct bp){
        for(BaseProduct b : menu){
            if(b.getTitle().equals(bp.getTitle())){
                return b;
            }
        }
        return null;
    }

    public void increaseOrderedTimes(MenuItem mn){
        for(MenuItem m : realMenu){
            if(m.getTitle().equals(mn.title)){
                m.setNumberOfTimesOrdered(m.getNumberOfTimesOrdered() + 1);
            }
        }
    }

    public MenuItem findMenuItem(MenuItem m){
        for(MenuItem mn : realMenu){
            if(mn.getTitle().equals(m.getTitle())){
                return mn;
            }
        }
        return null;
    }

    public BaseProduct findProduct2(String title){
        for(BaseProduct b: menu){
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }


    public User findUser(String name){
        for(User u : users){
            if(u.getEmail().equals(name)){
                return u;
            }
        }
        return null;
    }
}
