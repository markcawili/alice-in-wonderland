/**
 * title: Actions.java
 * description: Actions class for Alice in Wonderland. Contains Action methods for use in game that trigger events
 * based on the action called.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

import java.util.HashMap;
import java.util.Map;

public class Actions extends Player {

    //Move method to move player to different rooms, passes argument direction and HashMap locations
    public void move(String direction, HashMap<String, Locations> locations) {

        direction = direction.toLowerCase(); //input direction, convert to lowercase
        Locations current = locations.get(getLocation()); //location object for current location
        String[] adjacent = current.getAdjacent(); //get adjacent rooms to current
        Enemy enemy = new Enemy(); //enemy object for thief randomizer

        //Switch case for direction player wants to go to
        switch (direction) {
            case "north":
            case "n":
                if (!adjacent[0].equals("-")) {
                    setLocation(adjacent[0]);
                } else {
                    System.out.println("You can't go this way.");
                }
                break;
            case "south":
            case "s":
                if (!adjacent[1].equals("-")) {
                    setLocation(adjacent[1]);
                } else {
                    System.out.println("You can't go this way.");
                }
                break;
            case "east":
            case "e":
                if (!adjacent[2].equals("-")) {
                    setLocation(adjacent[2]);
                } else {
                    System.out.println("You can't go this way.");
                }
                break;
            case "west":
            case "w":
                if (!adjacent[3].equals("-")) {
                    setLocation(adjacent[3]);
                } else {
                    System.out.println("You can't go this way.");
                }
                break;
            default:
                System.out.println("That is not a valid direction, please try again.");
                break;
        }

        //if current location is same as index 4 which is the room itself then set counter to 1
        if (current.getLocationName().equals(adjacent[4])) {
            current.setCounter("1");
        }

        //if counter is 0 then print out initial description
        if (locations.get(getLocation()).getCounter().contains("0")) {
            System.out.println(locations.get(getLocation()).getDescription());
            //else print return message
        } else {
            System.out.println("You are back at the " + locations.get(getLocation()).getLocationName());
        }

        //if location is not the three outlined below, call thiefSpawner method which randomly chances a thief
        if (!locations.get(getLocation()).getLocationName().contains("Riverbank") &&
                !locations.get(getLocation()).getLocationName().contains("White Rabbit's House") &&
                !locations.get(getLocation()).getLocationName().contains("Croquet Court")) {
            enemy.thiefSpawner();
        }
    }

    //Method to look at current room, items, and health. Calls location class look method, passes HashMap locations
    public void lookAround(HashMap<String, Locations> locations) {

        Locations current = locations.get(getLocation()); //location object for current location

        System.out.println(current.getDescription()); //print description

            //if for room items
            if (current.getRoomItems().isEmpty()) {
                System.out.println("No items in the room.");
                // else print out items in room
            } else {
                System.out.print("Item: ");
                for (Map.Entry<String, Item> elt : current.getRoomItems().entrySet()) { //loop through items
                    System.out.print(elt.getKey() + ", ");
                }
                System.out.println("is in the room.");

                //if for room characters
            } if (current.getRoomCharacters().isEmpty()) {
                System.out.println("No characters in the room.");
                // else print out characters in room
            } else {
                System.out.print("NPC: ");
                for (Map.Entry<String, Characters> blt : current.getRoomCharacters().entrySet()) {
                    System.out.print(blt.getKey() + ", ");
                }
                System.out.println("is in the room.");
            }
        System.out.println("Health: " + getPlayerHealth());

        }

    //Method to talk to character in current room, passes String character and HashMap locations
    public void talk(String character, HashMap<String, Locations> locations) {

        Minigame minigame = new Minigame(); //minigame object to call minigame methods
        Locations current = locations.get(getLocation()); //location object to get current location

        //for current room character talked to, if counter is 0
        if (current.getRoomCharacters().get(character).getCounter().contains("0")) {

            //print out initial dialogue then set counter to 1
            System.out.println(current.getRoomCharacters().get(character).getCharDialogue());
            current.getRoomCharacters().get(character).setCounter("1");

            //if pocketwatch in room ,set counter to pick up as 0
            if (current.getRoomItems().containsKey("pocketwatch")) {
                current.getRoomItems().get("pocketwatch").setCanPickUp("0");
                System.out.println("[You can now pick up the pocketwatch!]");
            }

            //if teacup in room, set counter to pick up as 0
            if (current.getRoomItems().containsKey("teacup")) {
                current.getRoomItems().get("teacup").setCanPickUp("0");
                System.out.println("[You can now pick up the teacup!]");
            }

            //else if current room character talked to counter is not 0
        } else {

            //print a secondary dialogue
            System.out.println(current.getRoomCharacters().get(character).getCharRepeatDialogue());

            //if it is the caterpillar, prompt game
            if (current.getRoomCharacters().containsKey("the caterpillar")) {
                System.out.println("So, do you want to play?");
                minigame.additionGame();
                //if game won, if hookah in room pickup counter is 0, print simple message
                if (minigame.additionWinCount == 1) {
                    if (current.getRoomItems().get("hookah").getCanPickUp().contains("0")) {
                        System.out.println("Wasn't that fun!");
                        //else if hookah counter is not 0 then can set it to 0, print message
                    } else {
                        current.getRoomItems().get("hookah").setCanPickUp("0");
                        System.out.println("Here is a hookah for your prize.");
                        System.out.println("[You can now pick up the Hookah]!");
                    }
                }
            }

            //if it is the duchess, prompt game
            if (current.getRoomCharacters().containsKey("the duchess")) {
                System.out.println("Or do you want to play the game?");
                minigame.guessingGame();
                //if game won, if king's staff in room pickup counter is 0, print simple message
                if (minigame.guessWinCount == 1) {
                    if (current.getRoomItems().get("king's staff").getCanPickUp().contains("0")) {
                        System.out.println("You're just showing off now Alice?");
                        //else if king's staff counter is not 0 then can set to 0
                    } else {
                        current.getRoomItems().get("king's staff").setCanPickUp("0");
                        System.out.println("Here is the King's staff as promised.");
                        System.out.println("[You can now pick up the King's staff!]");
                    }
                }
            }

        }
    }

    //Method to eat cake
    public void eat() {

        //inventory object for calling method
        Inventory inv = new Inventory();

        //if cake in inventory
        if (inv.getInventory().containsKey("cake")) {
            //if health is 100 or more
            if (getPlayerHealth() >= 100) {
                System.out.println("You are at max health");
                setPlayerHealth(100);
                //else eat cake to replenish HP
            } else {

                int currentHealth = getPlayerHealth() + 30;
                setPlayerHealth(currentHealth);
                System.out.println("You take a bite of the cake");

                //if health is 100 or more
                if (getPlayerHealth() >= 100) {
                    System.out.println("You are now at max health");
                    setPlayerHealth(100);
                    //else print out health
                } else {
                    System.out.println("Your health is now " + getPlayerHealth());
                }
            }
            //else if cake not in inv, print message
        } else {
            System.out.println("You don't have cake in your inventory!");
        }
    }

}

