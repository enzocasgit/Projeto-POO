package Model;

import Enum.ItemStatusEnum;

public class Item {
    public int id;
    public String name;
    public String returnDate;
    public String originLocation;
    public String currentLocation;
    public ItemStatusEnum status;

    public Item(int id, String name, String returnDate, String originLocation, String currentLocation, ItemStatusEnum status) {
        this.id = id;
        this.name = name;
        this.returnDate = returnDate;
        this.originLocation = originLocation;
        this.currentLocation = currentLocation;
        this.status = status;
    }
}
