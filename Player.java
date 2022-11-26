/**
 * title: Player.java
 * description: Player class for Alice in Wonderland. Represents the player of the game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

public class Player {

    //String for current player room
    private static String playerLocation;

    //String for player health
    private static int playerHealth = 100;

    //Getter and setter method for player location
    public String getLocation() {
        return playerLocation;
    }

    public void setLocation(String location) {
        this.playerLocation = location;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

}
