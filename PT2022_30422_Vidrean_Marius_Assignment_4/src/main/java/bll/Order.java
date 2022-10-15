package bll;

import model.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Order implements Serializable {
    User u;
    LocalDateTime date;
    LinkedList<MenuItem> list;
    private int calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;

    public Order(User u, LinkedList<MenuItem> list) {
        this.u = u;
        this.date = LocalDateTime.now();
        this.list = list;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LinkedList<MenuItem> getList() {
        return list;
    }

    public void setList(LinkedList<MenuItem> list) {
        this.list = list;
    }
}
