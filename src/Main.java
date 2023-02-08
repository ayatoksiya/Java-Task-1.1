import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);

        System.out.println("Please select an integer from the range of 0-99");

        int attemptCounter = 5;
        int selectedNumber;

        for (int attemptMax = 1; attemptMax <= 5; attemptMax++) {

            try {
                Scanner attempt = new Scanner(System.in);
                selectedNumber = attempt.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Incorrect input. Please start the game again.");
                break;
            }

            attemptCounter--;

            if (selectedNumber < 0 || selectedNumber > 99) {
                if (attemptCounter > 0) {
                    System.out.println("Incorrect input. Please select an integer from the range of 0-99");
                    System.out.println("Please try again. " + "Number of attempts left is: " + attemptCounter);
                } else {
                    System.out.println("Incorrect input.");
                    System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                }
            } else if (selectedNumber > numberToGuess) {
                System.out.println("Your number is GREATER than the one you are trying to guess.");
                if (attemptCounter > 0) {
                    System.out.println("Please try again. " + "Number of attempts left is: " + attemptCounter);
                } else {
                    System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                }
            } else if (selectedNumber < numberToGuess) {
                System.out.println("Your number is LOWER than the one you are trying to guess.");
                if (attemptCounter > 0) {
                    System.out.println("Please try again. " + "Number of attempts left is: " + attemptCounter);
                } else {
                    System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                }
            } else {
                System.out.println("You guessed it!");
                break;
            }
        }
    }
}