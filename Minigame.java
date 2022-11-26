import java.util.Scanner;

/**
 * title: Minigame.java
 * description: Minigame class for Alice in Wonderland. Contains methods for playable minigames in game.
 * date: November 25, 2022
 * ID# 3605866
 * @author Mark Cawili
 * @version 1.0
 * @copyright 2022 Mark Cawili
 */

public class Minigame {

    //Variables for game win count switches
    int guessWinCount = 0;
    int additionWinCount = 0;

    //Method for guessing minigame
    public void guessingGame() {

        String start; //variable for user input
        Scanner startGame = new Scanner(System.in); //scanner for input

        start = startGame.next().toLowerCase();

        //if user says yes
        if (start.equals("yes")) {

            Scanner reader = new Scanner(System.in); //scanner for user answers

            int counter = 3; //counter for tries
            int number = 1 + (int) (10 * Math.random()); //initiates random number between 1-10
            int input, i;

            System.out.println("Guess a number between one to 10. You have 3 chances!");

            //for each i less than counter
            for (i = 0; i < counter; i++) {

                System.out.println("What's the number sweet Alice?");
                input = reader.nextInt();

                //if guess is right, wincount switch to 1 and break out of method
                if (number == input) {
                    System.out.println("Hooray! You guessed right!");
                    guessWinCount = 1;
                    break;
                    //else keep asking based on number given
                } else if (number > input && (i != counter - 1)) {
                    System.out.println("Higher!");
                } else if ((number < input) && (i != counter - 1)) {
                    System.out.println("Lower!");
                }
            }

            //if counter reaches 3 then end and player can retry
            if (i == counter) {
                System.out.println("You guessed all 3 times wrong!");
                System.out.println("It was " + number);
                System.out.println("Talk to me if you want to try again. Ha!");
            }

            //else if no
        } else if (start.equals("no")) {
            System.out.println("Very well then");
            //handles wrong input, has to talk to char again
        } else {
            System.out.println("What?");
        }

    }

    //Method for addition game
    public void additionGame() {

        String start; //variable for user input
        Scanner startGame = new Scanner(System.in); //scanner for input

        start = startGame.next().toLowerCase();

        //if user says yes
        if (start.equals("yes")) {

            Scanner reader = new Scanner(System.in); //scanner for user answers

            int counter = 3; //counter for number of questions to be asked
            int input, i;

            System.out.println("Add these numbers and give me the sum, get all 3 correct and you win!");

            //for each i less than counter
            for (i = 0; i < counter; i++) {

                //variables for two numbers to be added and sum
                int numOne = (1 + (int) (10 * Math.random()) + 1 + (int) (10 * Math.random()));
                int numTwo = (1 + (int) (10 * Math.random()) + 1 + (int) (10 * Math.random()));
                int sum = numOne + numTwo;

                System.out.println("What is the sum of " + numOne + " and " + numTwo);
                input = reader.nextInt();

                //if wrong number given once, end method, talk to retry
                if (sum != input) {
                    System.out.println("Wrong! You lose!");
                    System.out.println("Talk to me if you want to try again!");
                    return;
                    //else is correct
                } else {
                    System.out.println("Correct!");
                }
            }

            //if all three right, wincount switch to 1
            if (i == counter) {
                System.out.println("You answered all 3 right!");
                additionWinCount = 1;
            }

            //else if player says no
        } else if (start.equals("no")) {
            System.out.println("Fine, don't play!");
            //handles wrong input
        } else {
            System.out.println("Hmm?");
        }
    }

}

