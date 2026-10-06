import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MenuItem {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - ₹" + price;
    }
}

interface Menu {
    Iterator<MenuItem> createIterator();
}

class BreakfastMenu implements Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public BreakfastMenu() {
        addItem("Idli", "Soft steamed rice cakes", 40);
        addItem("Dosa", "Crispy rice pancake", 60);
        addItem("Upma", "South Indian breakfast dish", 50);
    }

    public void addItem(String name, String description, double price) {
        menuItems.add(new MenuItem(name, description, price));
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class LunchMenu implements Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public LunchMenu() {
        addItem("Veg Thali", "Rice, dal, vegetables and chapati", 150);
        addItem("Biryani", "Vegetable rice preparation", 180);
        addItem("Fried Rice", "Vegetable fried rice", 120);
    }

    public void addItem(String name, String description, double price) {
        menuItems.add(new MenuItem(name, description, price));
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class DinnerMenu implements Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public DinnerMenu() {
        addItem("Chapati", "Indian flatbread", 40);
        addItem("Paneer Curry", "Paneer cooked in spicy gravy", 140);
        addItem("Dal Rice", "Dal served with rice", 100);
    }

    public void addItem(String name, String description, double price) {
        menuItems.add(new MenuItem(name, description, price));
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class Waitress {
    private Menu breakfastMenu;
    private Menu lunchMenu;
    private Menu dinnerMenu;

    public Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        System.out.println("===== BREAKFAST MENU =====");
        printMenu(breakfastMenu.createIterator());

        System.out.println("\n===== LUNCH MENU =====");
        printMenu(lunchMenu.createIterator());

        System.out.println("\n===== DINNER MENU =====");
        printMenu(dinnerMenu.createIterator());
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Menu breakfastMenu = new BreakfastMenu();
        Menu lunchMenu = new LunchMenu();
        Menu dinnerMenu = new DinnerMenu();

        Waitress waitress =
                new Waitress(breakfastMenu, lunchMenu, dinnerMenu);

        waitress.printMenu();
    }
}