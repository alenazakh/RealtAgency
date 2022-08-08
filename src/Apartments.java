import java.util.ArrayList;

public class Apartments extends RealEstate {
    int floor;
    int numberOfRooms;
    String title;




    public Apartments(int id, String address, double area, double cost, int floor, int numberOfRooms) {
        super(id, address, area, cost);
        this.title = "Apartment";
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
    }


    @Override
    protected void getInfoAbout() {
        System.out.printf("ID: %d. Subcategory: %s. Title: %s. Address: %s. Area: %.1f. Floor: %d. Rooms: %d. " +
                "Cost: %.2f.\n", this.id, this.category, this.title, this.address, this.area, this.floor,
                this.numberOfRooms, this.cost);
    }

}