/**
 * title: Item.java
 * description: Item class for Alice in Wonderland. Represents Item objects for use in game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

public class Item {

    //String for itemName
    private final String itemName;

    //String for itemDesc
    private final String itemDescription;

    //String for itemLocation
    private final String itemLocation;

    //String for pickUp switch
    private String canPickUp;

    //Constructor for Item, passes variables
    public Item(String name, String description, String location, String canPickUp) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemLocation = location;
        this.canPickUp = canPickUp;
    }

    //Getters for the variables
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public String getCanPickUp() {
        return canPickUp;
    }

    //Setter for canPickUp variable
    public void setCanPickUp(String canPickUp) {
        this.canPickUp = canPickUp;
    }

}

