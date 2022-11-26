/**
 * title: Wonderland.java
 * description: Main class for the Alice in Wonderland text-based game. Runs the game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

/**
 * DOCUMENTATION...
 */

/**
 *
 * Alice in Wonderland Text-Based Game
 *
 * Purpose and Description
 *
 * A Java run text-based game adapted from and based on the 1885 novel by Lewis Carroll, "Alice's Adventures in
 * Wonderland".
 *
 * This program presents a playable text-based game run entirely by the player through commands inputted into the
 * console. Players are able to type in a variety of commands that do specific actions within the game. The game
 * includes multiple locations, items, characters for the player to interact with. There are a variety of events in the
 * game like minigames, thief encounters, and different dialogues with characters and locations. The goal of the player
 * is to collect a number of treasures to present to a certain character to get out of the fictional world of
 * Wonderland.
 *
 * Compiling and running instructions
 * Change to directory containing the source code.
 * Compile:     javac Wonderland.java
 * Run:         java Wonderland
 */

/**
 *
 * Classes
 *
 * public class Wonderland
 *  This is the main public class for this application.
 *
 * public class Player
 *  Player class for Alice in Wonderland. Contains variables that represent the player in the game.
 *
 * public class Verbs
 *  Verbs class for Alice in Wonderland. Contains variables that represent Verb objects for input verification in game.
 *
 * public class Item
 *  Item class for Alice in Wonderland. Contains variables that represent Item objects for use in game.
 *
 * public class Characters
 *  Characters class for Alice in Wonderland. Contains variables that represent Character objects for use in game.
 *
 * public class Locations
 *  Locations class for Alice in Wonderland. Contains variables that represent Location objects for use in game.
 *
 * public class Minigame
 *  Minigame class for Alice in Wonderland. Contains methods for playable minigames in game.
 *
 * public class Inventory extends Player
 *  Inventory class for Alice in Wonderland. Represents the player's Inventory in-game. Contains methods for inventory
 *  use.
 *
 * public class Actions extends Player
 *  Actions class for Alice in Wonderland. Contains Action methods for use in game that trigger events based on the
 *  action called.
 *
 * public class Enemy
 *  Enemy class for Alice in Wonderland. Contains method to randomize thief spawn per move between locations.
 *  Represents a thief encounter/fight sequence.
 *
 * public class Control
 *  Control class for Alice in Wonderland. Contains methods that load in the text files for use in-game. Contains a
 *  method that takes and verifies user input against valid actions.
 *
 * Wonderland Methods
 *
 *  public static void main(String args[])
 *   This method is used to execute the application
 *
 *  private void runGame()
 *   This method loads in the HashMaps needed to load in the locations, items, and characters. It also creates objects
 *   of all classes with methods to be used for the game. Sets initial location and calls inputVerify() of the Control
 *   class to take user input and call corresponding methods based on the input the player types in.
 *
 * Player Methods
 *
 *  public String getLocation()
 *   This method returns the location of the player
 *
 *  public void setLocation(String location)
 *   This method sets the location of the player, passes in String location
 *
 *  public int getPlayerHealth()
 *   This method returns the health of the player
 *
 *  public void setPlayerHealth(int playerHealth)
 *   This method sets the health of the player, passes in int playerHealth
 *
 * Verbs Methods
 *
 *  public Verbs(String action, String group)
 *   Constructor for Verbs class - this method is used to set up Verb objects
 *
 *  public String getAction()
 *   This method returns the action the player inputs if valid
 *
 *  public String getGroup()
 *   This method returns the group of the action the valid input is assigned to
 *
 * Item Methods
 *
 *  public Item(String name, String description, String location, String canPickUp)
 *   Constructor for Item class - this method is used to set up Item objects
 *
 *  public String getItemName()
 *   This method returns the name of the item
 *
 *  public String getItemDescription()
 *   This method returns the description of the item
 *
 *  public String getItemLocation()
 *   This method returns the location of the item
 *
 *  public String getCanPickUp()
 *   This method return the CanPickUp counter of the item which determines if the player can pick the item up or not
 *
 *  public void setCanPickUp(String canPickUp)
 *   This method sets the CanPickUp counter of the item, passes in String canPickUp
 *
 * Characters Methods
 *
 *  public Characters(String name, String charLocation, String charDialogue, String counter, String charRepeatDialogue)
 *   Constructor for Characters class - this method is used to set up Characters objects
 *
 *  public String getCharName()
 *   This method returns the name of the character
 *
 *  public String getCharLocation()
 *   This method returns the location of the character
 *
 *  public String getCharDialogue()
 *   This method returns the primary dialogue of the character
 *
 *  public String getCounter()
 *   This method returns the counter of the character which determines if primary or secondary dialogue is to be
 *   printed based on if the player has talked to the character already or not
 *
 *  public String getCharRepeatDialogue()
 *   This method returns the secondary dialogue of the character
 *
 *  public void setCounter(String counter)
 *   This method sets the counter of the character, passes in String counter
 *
 * Locations Methods
 *
 *  public Locations(String name, String description, String[] adjacent, HashMap<String, Item> roomItems,
 *  HashMap<String, Characters> roomCharacters, String counter)
 *   Constructor for Locations class - this method is used to set up Locations objects
 *
 *  private void setItems(HashMap<String, Item> items)
 *   This method sets the items into their respective locations, called in the Locations constructor. Passes in
 *   HashMap items
 *
 *  private void setCharacters(HashMap<String, Characters> characters)
 *   This method sets the characters into their respective locations, called in the Locations constructor. Passes in
 *   HashMap characters
 *
 *  public String getLocationName()
 *   This method returns the name of the location
 *
 *  public String[] getAdjacent()
 *   This method returns the adjacent rooms of the current location
 *
 *  public String getDescription()
 *   This method returns the description of the location
 *
 *  public HashMap<String, Item> getRoomItems()
 *   This method returns the HashMap of the current location's items
 *
 *  public HashMap<String, Characters> getRoomCharacters()
 *   This method returns the HashMap of the current location's characters
 *
 *  public String getCounter()
 *   This method returns the counter of the location which determines if the primary or secondary description of the
 *   location is to be printed. This is based on if the player has already visited the location or not.
 *
 *  public void setCounter(String counter)
 *   This method sets the counter of the location, passes in String counter
 *
 * Minigame Methods
 *
 *  public void guessingGame()
 *   This method runs the guessing minigame available within the game
 *
 *  public void additionGame()
 *   This method runs the addition minigame available within the game
 *
 * Inventory Methods
 *
 *  public void add(String item, HashMap<String, Locations> locations)
 *   This method adds the given item in the current location into the player's inventory. Passes in String item and
 *   HashMap locations
 *
 *  public void drop(String item, HashMap<String, Locations> locations)
 *   This method drops the given item in the inventory of the player into the current location. Passes in String item
 *   and Hashmap locations
 *
 *  public void lookInventory()
 *   This method looks into and prints out the inventory of the player
 *
 *  public void lookItem(String item)
 *   This method prints out the description of the given item. Passes in String item
 *
 *  public HashMap<String, Item> getInventory()
 *   This method returns the inventory HashMap
 *
 * Actions Methods
 *
 *  public void move(String direction, HashMap<String, Locations> locations)
 *   This method moves the player in the given cardinal direction if valid. Passes in String direction and HashMap
 *   locations
 *
 *  public void lookAround(HashMap<String, Locations> locations)
 *   This method prints out the description of the current location, items, characters in the room, and the player's
 *   health. Passes in HashMap locations
 *
 *  public void talk(String character, HashMap<String, Locations> locations)
 *   This method prints out the dialogue of the given character. Passes in String character and HashMap locations
 *
 *  public void eat()
 *   This method replenishes the health of the player if called with the cake item
 *
 * Enemy Methods
 *
 *  public void thiefSpawner()
 *   This method generates a random thief to spawn. If spawned, a fight sequence is run for the player to fight the
 *   thief.
 *
 *  private void enemyAttack()
 *   This method is used to run an enemy attack sequence within the thiefSpawner() method every time the player makes
 *   a decision
 *
 * Control Methods
 *
 *  private static void loadVerbs()
 *   This method loads in the Actions.txt file into the verbs ArrayList
 *
 *  public static HashMap<String, Locations> loadLocations(HashMap<String, Item> roomItems)
 *   This method loads in the Locations.txt file into the locations HashMap. Also sets the loaded characters into the
 *   roomCharacters HashMap and sets items in as well. Passes roomItems HashMap. Returns locations
 *
 *  public static HashMap<String, Item> loadItems()
 *   This method loads in the Items.txt file into the items HashMap, returns items
 *
 *  private static HashMap<String, Characters> loadCharacters()
 *   This method loads in the Characters.txt file into the characters HashMap, returns characters
 *
 *  public static void loadHelp()
 *   This method loads in the Help.txt file, prints it out
 *
 *  public static String[] inputVerify()
 *   This method is used to verify user input against valid actions as available in the verbs ArrayList. Returns an
 *   array which represents the verified group label and the other input typed in by the user.
 *
 *  public static ArrayList<Verbs> getVerbs()
 *   This method is used to return the verbs ArrayList
 *
 * Player Instance Variables
 *
 *  private static String playerLocation; - String to hold current playerLocation
 *  private static int playerHealth = 100; - int to hold current playerHealth, initialized to 100 at the start
 *
 * Verbs Instance Variables
 *
 *  private final String action; - String to hold loaded action verb
 *  private final String group; - String to hold loaded action group
 *
 * Item Instance Variables
 *
 *  private final String itemName; - String to hold loaded item name
 *  private final String itemDescription; - String to hold loaded item description
 *  private final String itemLocation; - String to hold loaded item location
 *  private String canPickUp; - String to hold loaded canPickUp counter
 *
 * Characters Instance Variables
 *
 *  private final String charName; - String to hold loaded character name
 *  private final String charLocation; - String to hold loaded character location
 *  private final String charDialogue; - String to hold loaded character primary dialogue
 *  private final String charRepeatDialogue; - String to hold loaded character secondary dialogue
 *  private String counter; - String to hold loaded character dialogue counter
 *
 * Locations Instance Variables
 *
 *  private final String locationName; - String to hold loaded location name
 *  private final String[] adjacent; - String array to hold loaded adjacent rooms to current
 *  private final String locationDescription; - String to hold loaded location description
 *  private final HashMap<String, Item> roomItems = new HashMap<>(); - HashMap<String, Item> roomItems for loaded
 *   room items
 *  private final HashMap<String, Characters> roomCharacters = new HashMap<>(); - HashMap<String, Characters>
 *   roomCharacters for loaded room characters
 *  private String counter; - String to hold loaded location counter
 *
 * Minigame Instance Variables
 *
 *  int guessWinCount = 0; - int to hold the number switch that represents a won guessing game, 0 at the start no win
 *  int additionWinCount = 0; - int to hold the number switch that represents a won addition game, 0 at the start no win
 *
 * Inventory Instance Variables
 *
 *  private static HashMap<String, Item> inventory = new HashMap<>(); - HashMap<String, Item> inventory for loaded
 *   inventory items
 *
 * Control Instance Variables
 *
 *  static ArrayList<Verbs> verbs = new ArrayList<>(); - ArrayList<Verbs> verbs for loaded verbs
 *
 */

/**
 * Due to the length and complexity of the test plan. This will be provided in an independent document. Please see
 * this document for the test plan of this program - "Testing Document - Alice in Wonderland".
 */

/**
 * CODE...
 */

import java.util.HashMap;
import java.util.Scanner;

public class Wonderland {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String option;

        while (true) {
            System.out.println("Welcome to Alice in Wonderland");
            System.out.println("Please choose an option");
            System.out.println("1. Start game");
            System.out.println("2. How to play");
            System.out.println("x. Exit");

            option = input.nextLine();

            switch (option) {
                case "1":
                    Wonderland game = new Wonderland();
                    game.runGame();
                    break;
                case "2":
                    Control.loadHelp();
                    System.out.println();
                    break;
                case "x":
                case "X":
                    System.exit(0);
                default:
                    System.out.println("Not a valid selection");
                    System.out.println();
                    break;
            }
        }

    }

    private void runGame() {

        //Objects of each to call methods
        Actions actions = new Actions();
        Inventory inv = new Inventory();
        Player player = new Player();

        //Load items, rooms, characters
        HashMap<String, Item> items = Control.loadItems();
        HashMap<String, Locations> rooms = Control.loadLocations(items);

        //Set and print out initial location description
        player.setLocation("Riverbank");
        System.out.println(rooms.get(actions.getLocation()).getDescription());

        //continuously takes user input
        while (true) {

            //runs method that takes user input and verifies against valid commands, if valid, returns commands
            String[] command = Control.inputVerify();

            //catches NullPointerException
            try {

                    //if input group equals TAKE
                if (command[0].equals("TAKE")) {
                    //store String name as multi string name input
                    if (command.length >= 2) {
                        String name = "";
                        for (int i = 1; i < command.length; i++) {
                            name = name + command[i] + " ";
                        }
                        name = name.trim();
                        //add item from room to inventory
                        inv.add(name, rooms);
                    }


                    //if input group equals DROP
                } else if (command[0].equals("DROP")) {
                    //store String item as multi string item name input
                    if (command.length >= 2) {
                        String item = "";
                        for (int i = 1; i < command.length; i++) {
                            item = item + command[i] + " ";
                        }
                        item = item.trim();
                        //drop item from inventory to room
                        inv.drop(item, rooms);
                    }


                    //if input group equals MOVE
                } else if (command[0].equals("MOVE")) {
                    //move player between rooms
                    actions.move(command[1], rooms);


                    //if input group equals LOOK
                } else if (command[0].equals("LOOK")) {
                    //if second command is around
                    if (command[1].equals("around")) {
                        //look at room
                        actions.lookAround(rooms);
                    //else look at item
                    } else {
                        //store String item as multi string item name input
                        if (command.length >= 2) {
                            String item = "";
                            for (int i = 1; i < command.length; i++) {
                                item = item + command[i] + " ";
                            }
                            item = item.trim();
                            //if item not in inventory, print message, else look at item
                            if (!inv.getInventory().containsKey(item)) {
                                if (command.length == 2) {
                                    System.out.println(command[1] + " not in your inventory.");
                                } else {
                                    System.out.println(command[1] + " " + command[2] + " not in your inventory.");
                                }
                            } else {
                                //look at item in inventory
                                inv.lookItem(item);
                            }
                        }
                    }


                    //if input group equals TALK
                } else if (command[0].equals("TALK")) {
                    //store String name as multi string character name input
                    if (command.length >= 2) {
                        String name = "";
                        for (int i = 1; i < command.length; i++) {
                            name = name + command[i] + " ";
                        }
                        name = name.trim();
                        //talk to character in room
                        actions.talk(name, rooms);
                    }


                    //if input group equals EAT and command[1] is cake
                } else if (command[0].equals("EAT") && command[1].equals("cake")) {
                    //player can eat cake
                    actions.eat();


                    //if user gives only one command
                } else if (command.length == 1) {


                    //if input group equals INVENTORY
                    if (command[0].equals("INVENTORY")) {
                        //show inventory
                        inv.lookInventory();


                        //if player says help within game
                    } else if (command[0].equals("help")) {
                        Control.loadHelp();


                        //if player says quit then exit program
                    } else if (command[0].equals("quit")) {
                        System.out.println("Going back to menu");
                        System.out.println("Thank you for playing!");
                        System.out.println();
                        return;
                    }

                    //if a single command direction given
                } else if (command[0].equals("DIRECTION")) {
                    //move player between rooms
                    actions.move(command[1], rooms);
                }

                //Condition statement to win the game

                if (actions.getLocation().contains("Croquet Court") &&
                        rooms.get("White Rabbit's House").toString().contains("teacup") &&
                        rooms.get("White Rabbit's House").toString().contains("hookah") &&
                        rooms.get("White Rabbit's House").toString().contains("gloves") &&
                        rooms.get("White Rabbit's House").toString().contains("king's staff") &&
                        rooms.get("White Rabbit's House").toString().contains("gold ring") &&
                        rooms.get("White Rabbit's House").toString().contains("book") &&
                        rooms.get("White Rabbit's House").toString().contains("pearl necklace") &&
                        rooms.get("White Rabbit's House").toString().contains("queen's crown")) {

                    System.out.println("I see that you have done what I have requested. Very well. I will send you back " +
                            "home. Don't come back unless you want to stay here forever. Until we meet again...");
                    System.exit(0);

                }
            } catch (NullPointerException ignored) {}
        }
    }

}





