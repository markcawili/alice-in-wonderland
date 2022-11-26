/**
 * title: Characters.java
 * description: Characters class for Alice in Wonderland. Represents Character objects for use in game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

public class Characters {

    //String for charName
    private final String charName;

    //String for charLocation
    private final String charLocation;

    //String for charDialogue
    private final String charDialogue;

    //String for secondary dialogue
    private final String charRepeatDialogue;

    //String for dialogue counter
    private String counter;

    //Constructor for Characters, passes name, location, dialogues and the counter of character
    public Characters(String name, String charLocation, String charDialogue, String counter,
                        String charRepeatDialogue) {
        this.charName = name;
        this.charLocation = charLocation;
        this.charDialogue = charDialogue;
        this.counter = counter;
        this.charRepeatDialogue = charRepeatDialogue;
    }

    //Getters for all variables

    public String getCharName() {
        return charName;
    }

    public String getCharLocation() {
        return charLocation;
    }

    public String getCharDialogue() {
        return charDialogue;
    }

    public String getCounter() {
        return counter;
    }

    public String getCharRepeatDialogue() {
        return charRepeatDialogue;
    }

    //Setter for chat counter
    public void setCounter(String counter) {
        this.counter = counter;
    }

}


