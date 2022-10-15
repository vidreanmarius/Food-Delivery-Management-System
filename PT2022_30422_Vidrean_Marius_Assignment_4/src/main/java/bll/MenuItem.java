package bll;

import java.io.Serializable;
import java.util.Objects;

public class MenuItem implements Serializable {
    public String title;
    private double rating;
    private int calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;
    public int numberOfTimesOrdered;

    public MenuItem(String title, double rating, int calories, double protein, double fat, double sodium, double price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        numberOfTimesOrdered = 0;
    }

    public MenuItem() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(title, menuItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

    public int getNumberOfTimesOrdered() {
        return numberOfTimesOrdered;
    }

    public void setNumberOfTimesOrdered(int numberOfTimesOrdered) {
        this.numberOfTimesOrdered = numberOfTimesOrdered;
    }

    @Override
    public String toString() {
        return title;
    }
}
