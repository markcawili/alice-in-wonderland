/**
 * title: Locations.java
 * description: Locations class for Alice in Wonderland. Represents Location objects for use in game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

import java.util.HashMap;
import java.util.Map;

public class Locations {

    //String for location name
    private final String locationName;

    //String array for adjacent rooms to loc
    private final String[] adjacent;

    //String for location desc
    private final String locationDescription;

    //HashMap for roomItems
    private final HashMap<String, Item> roomItems = new HashMap<>();

    //HashMap for roomCharacters
    private final HashMap<String, Characters> roomCharacters = new HashMap<>();

    //String counter for location revisit message
    private String counter;


    //Constructor for Location, passes all variables and HashMaps, calls setItems and setCharacters methods
    public Locations(String name, String description, String[] adjacent, HashMap<String, Item> roomItems,
                     HashMap<String, Characters> roomCharacters, String counter) {

        this.locationName = name;
        this.adjacent = adjacent;
        this.locationDescription = description;
        this.counter = counter;

        setItems(roomItems);
        setCharacters(roomCharacters);
    }

    //Method to set items into room, passes in items hashmap
    private void setItems(HashMap<String, Item> items) {
        for (Map.Entry<String, Item> item : items.entrySet()) { //loop through items, make set
            if (item.getValue().getItemLocation().equals(locationName)) { //if item location value is room name
                roomItems.put(item.getKey(), item.getValue()); //put item into room
            }
        }
    }

    //Method to set characters into room, passes in characters hashmap
    private void setCharacters(HashMap<String, Characters> characters) {
        for (Map.Entry<String, Characters> character : characters.entrySet()) { //loop through char, make set
            if (character.getValue().getCharLocation().equals(locationName)) { //if char location value is room name
                roomCharacters.put(character.getKey(), character.getValue()); //put char into room
            }
        }
    }

    //Getters for all variables and hashmaps
    public String getLocationName() {
        return locationName;
    }

    public String[] getAdjacent() {
        return adjacent;
    }

    public String getDescription() {
        return locationDescription;
    }

    public HashMap<String, Item> getRoomItems() {
        return roomItems;
    }

    public HashMap<String, Characters> getRoomCharacters() {
        return roomCharacters;
    }

    public String getCounter() {
        return counter;
    }

    //Setter for the counter
    public void setCounter(String counter) {
        this.counter = counter;
    }

}