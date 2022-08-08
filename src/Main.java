import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello. We help you to acquire the apartment of you dream.");
        ArrayList<RealEstate> allRealty = new ArrayList<RealEstate>();
        Apartments Apartment1 = new Apartments(1, "Serdicha St.", 60.0, 70000.0, 9, 2);
        allRealty.add(Apartment1);
        Apartments Apartment3 = new Apartments(3, "Asanalieva St.", 45.0, 46000.0, 2, 1);
        allRealty.add(Apartment3);
        Apartments Apartment5 = new Apartments(5, "Mstislavca St.", 84.0, 120000.0, 5, 3);
        allRealty.add(Apartment5);
        Persons currentUser = new Persons();
        String[] infoMenus = {"1 - Get my info.", "2 - Get info about apartments.", "3 - Change the budget.", "4 - Acquire the apartment.", "0 - Quit."};
        int menuItem;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (String item : infoMenus) {
                System.out.printf(item + "\n");
            }
            System.out.println("Please, enter menu item: ");
            menuItem = scanner.nextInt();
            scanner.nextLine();        // for further correct work nextLine() after nextInt()
            while (menuItem < 0 || menuItem > 4) {
                System.out.println("Incorrect data. Try again: ");
                menuItem = scanner.nextInt();
                scanner.nextLine();
            }
            if (menuItem == 0) {
                break;
            } else {
                switch (menuItem) {
                    case 1:
                        currentUser.getInfoAboutPerson();
                        break;
                    case 2:
                        System.out.println("Enter 1 - to see all apartments. Enter 2 - to see apartments in your " +
                                "budget.");
                        int menuChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (menuChoice) {
                            case 1:
                                RealEstate.printListAllForSale(currentUser, allRealty);
                                System.out.println("Remember the apartment ID to acquire specific apartment.");
                                break;
                            case 2:
                                RealEstate.printListInBudgetForSaleAll(currentUser, allRealty);
                                System.out.println("Remember the apartment ID to acquire specific apartment.");
                                break;
                            default: System.out.println("Something is happening.\n");
                        }
                        break;
                    case 3:
                        System.out.println("Enter new budget :");
                        double budget = scanner.nextDouble();
                        currentUser.changeBudget(budget);
                        break;
                    case 4:
                        System.out.println("Enter apartment ID for purchase:");
                        int idRealEstate = scanner.nextInt();
                        scanner.nextLine();
                        currentUser.makeDeal(idRealEstate, allRealty);
                        break;
                    default: System.out.println("Something is happening.\n");
                }
            }
        }
        System.out.println("Bye...Bye...");
    }
}