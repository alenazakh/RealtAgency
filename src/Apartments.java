import java.util.ArrayList;

public class Apartments {
    int id;
    String address;
    double area;
    double cost;
    boolean forSale;

    public Apartments (int id, String address, double area, double cost) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.cost = cost;
        this.forSale = true;
    }

    public Apartments (int id, double area, double cost) {
        this.id = id;
        this.address = "Unknown";
        this.area = area;
        this.cost = cost;
        this.forSale = true;
    }

    public void increaseCost (double arg) {
        this.cost += arg;
    }

    public void decreaseCost (double arg) {
        this.cost -= arg;
    }

    public void makeNotForSale () {
        if (this.forSale == true) {
            this.forSale = false;
        }
    }

    public void makeForSale () {
        if (this.forSale == false) {
            this.forSale = true;
        }
    }

    public void getInfoAboutApartment(Persons person) {
        int verificationCode = Persons.askPasswordToVerification();
        if (person.getPassword() == verificationCode) {
            System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", this.id, this.address, this.area, this.cost);
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

    public void getInfoAboutApartment(int personsPassword, int verificationCode) {
        if (personsPassword == verificationCode) {
            System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", this.id, this.address, this.area, this.cost);
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

    public static void printListAllForSaleApartments (Persons person, ArrayList<Apartments> list) {
        int verificationCode = Persons.askPasswordToVerification();
        if (person.getPassword() == verificationCode) {
            for (Apartments item : list) {
                if (item.forSale) {
                    System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", item.id, item.address, item.area, item.cost);
                }
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

    public static void printListInBudgetForSaleAllApartments (Persons person, ArrayList<Apartments> list) {
        int verificationCode = Persons.askPasswordToVerification();
        if (person.getPassword() == verificationCode) {
            for (Apartments item : list) {
                if (item.forSale && item.cost <= person.budget) {
                    System.out.printf("ID: %d. Address: %s. Area: %.1f. Cost: %.2f.\n", item.id, item.address, item.area, item.cost);
                }
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }
}