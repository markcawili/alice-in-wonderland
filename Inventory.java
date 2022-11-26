/**
 * title: Inventory.java
 * description: Inventory class for Alice in Wonderland. Represents the player's Inventory in-game. Includes methods
 * for inventory use.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

import java.util.HashMap;
import java.util.Map;
public class Inventory extends Player {

    // HashMap for player inventory
    private static HashMap<String, Item> inventory = new HashMap<>();

    //Method to add item to player inventory, passes String item and HashMap locations
    public void add(String item, HashMap<String, Locations> locations) {

        //locations object with current location
        Locations current = locations.get(getLocation());
        //initialize toAdd item object
        Item toAdd = null;

        //if inventory size is 4 then it's full
        if (inventory.size() == 4) {
            System.out.println("Your inventory is full");
            //else if item in room and inventory less than 4
        } else if (inventory.size() < 4) {
            //if room contains item
            if (current.getRoomItems().containsKey(item)) {
                //if that item's canpickup counter is 0
                if (current.getRoomItems().get(item).getCanPickUp().contains("0")) {

                    //set object to add as the item in room
                    toAdd = current.getRoomItems().get(item);
                    //remove item from roomitems HashMap
                    current.getRoomItems().remove(item);
                    //add item name and value to player inventory, print message
                    inventory.put(toAdd.getItemName(), toAdd);
                    System.out.println(item + " added to your inventory");
                    //else can't pick up yet
                } else {
                    System.out.println("You can't pick that up yet. Talk to the character or find out what they need");
                }
                //else item is not in room
            } else {
                System.out.println("Sorry, " + item + " is not in the room.");
            }
        }
    }

    //Method to drop item from player inventory into room, passes String item and HashMap locations
    public void drop(String item, HashMap<String, Locations> locations) {

        //locations object with current location
        Locations current = locations.get(getLocation());
        //initialize toDrop item object
        Item toDrop = null;

        //if item is in player inventory
        if (inventory.containsKey(item)) {
            //set object to drop as the item
            toDrop = inventory.get(item);
            //remove the item from inventory
            inventory.remove(item);

            //put item dropped into roomitems hashmap
            current.getRoomItems().put(toDrop.getItemName(), toDrop);
            System.out.println(item + " was dropped");

            //try catch NullPointerException just in case these items dropped into wrong room
            try {
                //if these items in same room then it unlocks, removes item altogether
                if (current.getRoomItems().containsKey("pocketwatch") &&
                        current.getRoomItems().get("pearl necklace").getCanPickUp().contains("1")) {

                    current.getRoomItems().get("pearl necklace").setCanPickUp("0");
                    System.out.println("You've found it! Here is the pearl necklace I promised to give as a trade.");
                    System.out.println("[You can now pick up the pearl necklace]");
                    current.getRoomItems().remove("pocketwatch");

                    //if these items in same room then it unlocks, removes item altogether
                } else if (current.getRoomItems().containsKey("velvet hat") &&
                        current.getRoomItems().get("queen's crown").getCanPickUp().contains("1")) {

                    current.getRoomItems().get("queen's crown").setCanPickUp("0");
                    System.out.println("You found my hat! This is perfect for the start of the tea party! Here " +
                            "is the crown I promised as a trade");
                    System.out.println("[You can now pick up the Queen's Crown!]");
                    current.getRoomItems().remove("velvet hat");

                }
            } catch (NullPointerException ignored) {}

            //else item is not in inventory
        } else {
            System.out.println("Sorry, " + item + " is not in your inventory.");
        }
    }

    //Method to display player inventory
    public void lookInventory() {
        //if inventory is empty
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
            //else print out items in inventory
        } else {
            for (Map.Entry<String, Item> elt : inventory.entrySet()) {
                System.out.println(elt.getKey());
            }
        }
    }

    //Method to look at item in inventory, passes String item
    public void lookItem(String item) {
        System.out.println(inventory.get(item).getItemDescription());
    }

    //Getter for inventory HashMap
    public HashMap<String, Item> getInventory() {
        return inventory;
    }

}
