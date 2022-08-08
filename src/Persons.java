import java.util.ArrayList;
import java.util.Scanner;

public class Persons {
    String name;
    int age;
    double budget;
    private int password;
    ArrayList<Apartments> myRealty = new ArrayList<Apartments>();

    public Persons () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your age: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your budget: ");
        this.budget = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter your password (number from 1 to 9999: ");
        this.password = sc.nextInt();
        sc.nextLine();
        while (this.password < 1 || this.password > 9999) {
            System.out.println("Please, enter only number from 1 to 9999. Try again : ");
            this.password = sc.nextInt();
            sc.nextLine();
        }
    }

    public void changeBudget(double arg) {
        this.budget = arg;
    }

    public int getPassword () {
        return this.password;
    }

    public void getInfoAboutPerson() {
        int verificationCode = askPasswordToVerification();
        if (this.password == verificationCode) {
            System.out.printf("Name: %s. Age: %d. Current budget: %.2f.\n", this.name, this.age, this.budget);
            System.out.println("My acquired apartments:");
            int counts = 0;
            for (Apartments item : this.myRealty) {
                item.getInfoAboutApartment(this.password, verificationCode);
                counts += 1;
            }
            if (counts == 0) {
                System.out.println("none");
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }

    public static int askPasswordToVerification() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your password for verification: ");
        int password = sc.nextInt();
        //sc.close();
        return password;
    }

    public void makeDeal (int idApartmentToBuy, ArrayList<RealEstate> list) {
        int verificationCode = Persons.askPasswordToVerification();
        if (this.password == verificationCode) {
            int counts = 0;
            for (RealEstate item : list) {
                if (item.id == idApartmentToBuy) {
                    counts += 1;
                    if (this.budget >= item.cost && item.forSale) {
                        System.out.print("Are you sure, that you wont to buy: ");
                        item.getInfoAboutApartment(this.password, verificationCode);
                        System.out.println("Enter 0 for No, 1 for Yes.");
                        Scanner sc = new Scanner(System.in);
                        int answer = sc.nextInt();
                        sc.nextLine();
                        if (answer == 1) {
                            item.makeForSaleOrNot();
                            Apartments apartmentToBuy = item;
                            this.myRealty.add(apartmentToBuy);
                            //list.remove(item);
                        }
                    } else {
                        System.out.println("This apartment is out of your budget.");
                    }
                }
            }
            if (counts == 0) {
                System.out.println("We don't find apartment with such ID. Check ID");
            }
        } else {
            System.out.println("You entered the wrong password. Try again.");
        }
    }
}

