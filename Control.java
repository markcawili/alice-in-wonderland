/**
 * title: Control.java
 * description: Control class for Alice in Wonderland. Contains methods that load in the text files for use in-game.
 * Contains a method that takes and verifies user input against valid actions.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Control {

    //ArrayList to hold loaded verbs
    static ArrayList<Verbs> verbs = new ArrayList<>();

    //Method to load in verbs from text file
    private static void loadVerbs() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Actions.txt"));
            //String line represents line read by reader
            String line = reader.readLine();

            //while there is still lines to read
            while (line != null) {
                //while reader doesn't encounter break, keep reading
                while (!line.equals("BREAK")) {
                    String verb = line; //set verb as first line read

                    line = reader.readLine();
                    String group = line; //set group as line read

                    verbs.add(new Verbs(verb, group));

                    line = reader.readLine();
                }
                line = reader.readLine(); //will read null and end method
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File cannot be accessed");
        }
    }

    //Method to load Location.txt file into locations HashMap, passes HashMap roomItems, returns locations
    public static HashMap<String, Locations> loadLocations(HashMap<String, Item> roomItems) {
        try {
            //reader for file
            BufferedReader reader = new BufferedReader(new FileReader("Location.txt"));
            //String line represents line read by reader
            String line = reader.readLine();
            //hashmap for locations
            HashMap<String, Locations> locations = new HashMap<>();
            //hashmap for loaded characters
            HashMap<String, Characters> roomCharacters = loadCharacters();

            //while there is still lines to read
            while (line != null) {
                String name = line; //set name as first line read

                line = reader.readLine();
                String[] adjacent = line.split(","); //line will be adjacent rooms split

                line = reader.readLine();
                String counter = line; //line will be counter

                for (int i = 0; i < adjacent.length; i++) {
                    adjacent[i] = adjacent[i].trim(); //trim whitespace of each element of adjacent
                }

                line = reader.readLine();
                String description = ""; //description starts with no output

                //while reader doesn't encounter break, keep reading and adding to description
                while (!line.equals("BREAK")) {
                    description = description + line + '\n';
                    line = reader.readLine();
                }

                //put location into locations HashMap
                locations.put(name, new Locations(name, description, adjacent, roomItems, roomCharacters, counter));
                line = reader.readLine(); // read next location to be assigned
            }
            reader.close();
            return locations;
        } catch (IOException e) {
            System.out.println("File cannot be accessed");
        }
        return null;
    }

    //Method to load Items.txt file into items HashMap, returns items
    public static HashMap<String, Item> loadItems() {
        try {
            //reader for file
            BufferedReader reader = new BufferedReader(new FileReader("Items.txt"));
            //String line represents line read by reader
            String line = reader.readLine();
            //hashmap for items
            HashMap<String, Item> items = new HashMap<String, Item>();

            //while there is still lines to read
            while (line != null) {
                String name = line; //set name as first line read
                name = name.toLowerCase();

                line = reader.readLine();
                String canPickUp = line; //set canPickUp counter as line

                line = reader.readLine();
                String location = line.trim(); //set location as the line read, trim whitespace

                line = reader.readLine();
                String description = ""; //description starts with no output

                //while reader doesn't encounter break, keep reading and adding to description
                while (!line.equals("BREAK")) {
                    description = description + line + '\n';
                    line = reader.readLine();
                }

                // put item into items name into HashMap
                items.put(name, new Item(name, description, location, canPickUp));
                line = reader.readLine(); // read next item to be assigned
            }
            reader.close();
            return items;
        } catch (IOException e) {
            System.out.println("File cannot be accessed");
        }
        return null;
    }

    //Method to load Characters.txt file into characters HashMap, returns characters
    private static HashMap<String, Characters> loadCharacters() {
        try {
            //reader for file
            BufferedReader reader = new BufferedReader(new FileReader("Characters.txt"));
            //String line represents line read by reader
            String line = reader.readLine();
            //hashmap for characters
            HashMap<String, Characters> characters = new HashMap<String, Characters>();

            //while there is still lines to read
            while (line != null) {
                String name = line; //set name as first line read
                name = name.toLowerCase();

                line = reader.readLine();
                String location = line.trim(); //set location as the line read, trim whitespace

                line = reader.readLine();
                String counter = line; //set counter for dialogue as next line read

                line = reader.readLine();
                String dialogue = ""; //description starts with no output

                //while reader doesn't encounter SEPARATE, keep reading and adding to dialogue
                while (!line.equals("SEPARATE")) {
                    dialogue = dialogue + line + '\n';
                    line = reader.readLine();
                }

                line = reader.readLine();
                String dialogueTwo = ""; //dialogueTwo starts with no output

                //while reader doesn't encounter BREAK, keep reading and adding to dialogueTwo
                while (!line.equals("BREAK")) {
                    dialogueTwo = dialogueTwo + line;
                    line = reader.readLine();
                }

                // put character and character name into HashMap
                characters.put(name, new Characters(name, location, dialogue, counter, dialogueTwo));
                line = reader.readLine(); // read next item to be assigned
            }
            reader.close();
            return characters;
        } catch (IOException e) {
            System.out.println("File cannot be accessed");
        }
        return null;
    }

    //Method to load Help.txt file
    public static void loadHelp() {

        try {
            //reader for file
            Scanner reader = new Scanner(new File("Help.txt"));
            //ArrayList for the help contents
            ArrayList<String> helpArray = new ArrayList<>();

            //while there is still lines to read, add to the array each line
            while (reader.hasNextLine()) {
                helpArray.add(reader.nextLine());
            }

            //for each String s in helpArray, print it out
            for (String s : helpArray) {
                System.out.println(s);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File cannot be accessed");
        }
    }

    //Method that verifies user input, if valid, game continues
    public static String[] inputVerify() {

        //Scanner reader and load verbs call
        Scanner reader = new Scanner(System.in);
        loadVerbs();

        //receives user input, converts to lowercase, and then splits into array
        String input = reader.nextLine();
        input = input.toLowerCase();
        String[] command = input.split(" ");
        String[] verified = new String[1];

        //after input received, loop through verbs ArrayList
        for (Verbs a : getVerbs())
            //if command is one only
            if (command.length == 1) {
                //non-verb commands/invalid commands
                if (command[0].equals("quit")) {
                    verified = new String[]{"quit"};
                } else if (command[0].equals("help")) {
                    verified = new String[]{"help"};
                } else if ((command[0].equals("inventory")) || (command[0].equals("inv")) || (command[0].equals("i"))) {
                    verified = new String[]{"INVENTORY"};
                } else if ((command[0].equals("north")) || (command[0].equals("south")) ||
                            (command[0].equals("east")) || (command[0].equals("west")))  {
                    verified = new String[]{"DIRECTION", command[0]};
                    //System.out.println(Arrays.toString(verified));
                } else {
                    System.out.println("What?");
                }
                break;

            } else {

                    //if input matches an action verb in list
                    if (command[0].equals(a.getAction())) {

                        //if action verb contains specified group label then set command[0] to group
                        if (a.getGroup().contains("TAKE")) {
                            if (command.length == 2) {
                                verified = new String[]{"TAKE", command[1]};
                            } else if (command.length == 3) {
                                verified = new String[]{"TAKE", command[1], command[2]};
                            }

                        } else if (a.getGroup().contains("DROP")) {
                            if (command.length == 2) {
                                verified = new String[]{"DROP", command[1]};
                            } else {
                                verified = new String[]{"DROP", command[1], command[2]};
                            }

                        } else if (a.getGroup().contains("LOOK")) {
                            if (command[1].equals("around")) {
                                verified = new String[]{"LOOK", "around"};
                            } else if (command.length == 2) {
                                verified = new String[]{"LOOK", command[1]};
                            } else if (command.length == 3) {
                                verified = new String[]{"LOOK", command[1], command[2]};
                            }

                        } else if (a.getGroup().contains("TALK")) {
                            if (command.length == 3) {
                                verified = new String[]{"TALK", command[1], command[2]};
                            } else {
                                verified = new String[]{"TALK", command[1], command[2], command[3]};
                            }

                        } else if (a.getGroup().contains("MOVE")) {
                            verified = new String[]{"MOVE", command[1]};

                        } else if (a.getGroup().contains("EAT")) {
                            verified = new String[]{"EAT", command[1]};

                        } else if (a.getGroup().contains("DIRECTION")) {
                            verified = new String[]{"DIRECTION", command[1]};
                        }
            }

        }
        return verified;
    }

    //Getter method for verbs ArrayList
    public static ArrayList<Verbs> getVerbs() {
        return verbs;
    }

}





