/**
 * title: Enemy.java
 * description: Enemy class for Alice in Wonderland. Contains method to randomize thief spawn per move between
 * locations. Represents a thief encounter/fight sequence.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

import java.util.Scanner;
public class Enemy {

    //Inventory and player objects for calling methods
    Inventory inv = new Inventory();
    Player player = new Player();

    //Method for spawning thief enemy
    public void thiefSpawner() {

        //randomizer
        double randomNum = Math.random();

        //if random number is less than 0.25 for 25% chance
        if (randomNum < 0.25) {

            //spawn thief
            int enemyHealth = 100;
            System.out.println("A thief has appeared to rob you!");

            //while thief not dead
            while (enemyHealth > 0) {

                //New scanner and variable for input, convert to lowercase and put into array
                Scanner reader = new Scanner(System.in);
                String input = reader.nextLine();
                input = input.toLowerCase();
                String[] command = input.split(" ");

                //if for player damage or run
                if (command[0].equals("attack")) {
                    //if sword in inv
                    if (inv.getInventory().containsKey("sword")) {
                        enemyHealth = enemyHealth - 25;
                        System.out.println("You hit the thief for 25 damage!");
                        System.out.println("Thief health: " + enemyHealth);
                        //else punch
                    } else {
                        enemyHealth = enemyHealth - 10;
                        System.out.println("You punch the thief for 10 damage!");
                        System.out.println("Thief health: " + enemyHealth);
                    }
                    //call enemy attack method
                    enemyAttack();

                    //else if player runs
                } else if (command[0].equals("run")) {
                    //random chance to run
                    double randomRun = Math.random();
                    //50% chance
                    if (randomRun < 0.50) {
                        System.out.println("You successfully ran away from the thief!");
                        return;
                    } else {
                        System.out.println("You couldn't run away!");
                    }
                    //call enemy attack method
                    enemyAttack();
                    //handles wrong input
                } else {
                    System.out.println("What?");
                }
            }
            //if thief dies, health 0
            System.out.println("You killed the thief!");
        }

    }

    //Method for enemy attack
    private void enemyAttack() {

        //randomizer and damage for thief
        double randomEnemyDamage = Math.random();
        int damage = 33;

        //if for enemy damage, 50% chance to hit
        if (randomEnemyDamage < 0.50) {

            System.out.println("The thief hit you for " + damage + " damage!");

            //update player health and set
            int currentHealth = player.getPlayerHealth() - damage;
            player.setPlayerHealth(currentHealth);

            //if  0 or less, then Alice has died
            if (player.getPlayerHealth() <= 0) {
                System.out.println("You have died.");
                System.exit(0);
                //else print current health
            } else {
                System.out.println("Your health is " + player.getPlayerHealth());
            }
            //else thief misses
        } else {
            System.out.println("The thief tries to hit you but misses!");
        }
    }

}

