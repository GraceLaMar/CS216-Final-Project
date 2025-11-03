// lab8.java
// Grace La Mar
// AI Bot Binary Search
// 11-3-25

import java.io.IOException;
import static java.lang.System.in;

public class GuessMyNumberAI {
    public static void main(String[] args) throws java.io.IOException  {


    System.out.println("CS325 AI Bot Guessing Game...");
    System.out.print("Enter the largest number:");


    int lower = 1;
    var upper = readInt();

    System.out.println("Pick a number between " + lower + "and " + upper + "but don't tell me");
    var maxGuesses = (int) Math.ceil(Math.log(upper) / Math.log(2));
    System.out.println("I can guess your number in" + maxGuesses + "guesses");

    int min = lower;
    int max = upper;
    int guessCount = 0;
    boolean found = false;

    while/* */(min <= max && !found) {
        guessCount++;
        int guess = (min + max) / 2;
        System. out.print("Guess #" + guessCount + ": Is your number" + guess + "? (y/n):");
        char reply;
        reply = (char) in.read();
        clearBuffer();

        if (reply == 'y' || reply == 'Y') {
                System.out.println("I was able to guess your number in " + guessCount + " guesses!");
                found = true;
        } else if (reply == 'n' || reply == 'N') {
            System.out.print("Is your number higher or lower than " + guess + "? (h/l): ");
            char direction;
            direction = (char) System.in.read();
            clearBuffer();
        
            if (direction == 'h' || direction == 'H') {
                min = guess + 1;
            } else if (direction == 'l' || direction == 'L') {
                max = guess - 1;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 'l'.");
                break;
            }
        } else {
            System.out.println("Invalid Input. Please enter 'y' or 'n'.");
            break;
        }
        if (min > max) {
                System.out.println("Your responses are inconsistent — I think you made a mistake or weren’t truthful!");
                break;
        }
    }
    if (!found && min <= max) {
            System.out.println("Game over — couldn’t determine your number.");
    }
}

   private static int readInt() throws IOException {
        int number = 0;
        int ch;
        while ((ch = in.read()) != '\n' && ch != '\r') {
            if (ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
            }
        }
        return number;
    }

    private static void clearBuffer() throws IOException {
        while (in.available() > 0) {
            int ch = in.read();
            if (ch == '\n' || ch == '\r') break;
        }
    }
}
