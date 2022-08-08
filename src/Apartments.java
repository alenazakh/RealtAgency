import java.util.ArrayList;

public class Apartments extends RealEstate {
    int numberOfRooms;


    public Apartments (int id, double cost, String title, String address, double area) {
        this.title = "Apartment";
        this.address = address;
        this.area = area;
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


}