import java.util.ArrayList;
import java.util.Scanner;

public class RealEstate implements GoodsItem{
    int id;
    String category;
    String title;
    Double cost;
    boolean forSale;
    String address;
    double area;


    public RealEstate () {
        this.category = "Real Estate";
        this.id = 0;
        this.title = "Unknown";
        this.address = "Unknown";
        this.area = 0.0;
        this.cost = 0.0;
        this.forSale = true;
    }


    public RealEstate (int id, String title, String address, double area, double cost) {
        this.category = "Real Estate";
        this.id = id;
        this.title = title;
        this.address = address;
        this.area = area;
        this.cost = cost;
        this.forSale = true;
    }

    public void setCost () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the cost:");       // add exception
        this.cost = scanner.nextDouble();
    }

    public double getCost () {
        return this.cost;
    }

    public void makeForSaleOrNot () {
        if (this.forSale == false) {
            this.forSale = true;
        } else {
            this.forSale = false;
        }

    }

    public static void printListAllForSale (Persons person, ArrayList<RealEstate> list) {
        int verificationCode = Persons.askPasswordToVerification();
        if (person.getPassword() == verificationCode) {
            for (RealEstate item : list) {
                if (item.forSale) {
                    System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", item.id, item.address, item.area, item.cost);
                }
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

    public static void printListInBudgetForSaleAll (Persons person, ArrayList<RealEstate> list) {
        int verificationCode = Persons.askPasswordToVerification();
        if (person.getPassword() == verificationCode) {
            for (RealEstate item : list) {
                if (item.forSale && item.cost <= person.budget) {
                    System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", item.id, item.address, item.area, item.cost);
                }
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

}
