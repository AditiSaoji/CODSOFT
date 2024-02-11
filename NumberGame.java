import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Welcome to the Game Guess the Number...!");

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = r.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("I have selected a number between " + lowerLimit + " and " + upperLimit + ". Can you guess it?");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + (attempts + 1) + " attempts.");
                    totalAttempts += attempts + 1;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you have run out of attempts. The correct number was " + secretNumber + ".");
            }
            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        System.out.println("Game Over! You played " + roundsPlayed + " round(s) and your total score is " + totalAttempts + " attempts.");

        sc.close();
    }
}