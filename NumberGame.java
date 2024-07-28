import java.util.Random;
import java.util.Scanner;

 class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            int randomNumber = generateRandomNumber(1, 100);
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasWon = false;

            System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!hasWon) {
                System.out.println("You've used all your attempts. The correct number was " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("You won " + roundsWon + " rounds. Thanks for playing!");

        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
