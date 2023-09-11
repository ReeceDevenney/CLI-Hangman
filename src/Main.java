import java.io.*;
import java.util.Objects;

public class Main {

    static void gameLoop(String phrase, String secret, int incorrectCount) throws IOException {
        System.out.println(secret);
        System.out.println(incorrectCount + "/5 incorrect guesses");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Guess a letter: ");

        String guess = reader.readLine();
        StringBuilder holder = new StringBuilder();
        boolean correctCheck = false;

        for (int i = 0; i < phrase.length(); i++) {
            if(secret.charAt(i) == ' ') {
                holder.append(' ');
            } else if(secret.charAt(i) != '*') {
                holder.append(secret.charAt(i));
            } else if (phrase.charAt(i) == guess.charAt(0)) {
                holder.append(guess);
                correctCheck = true;
            } else {
                holder.append('*');
            }
        }

        if(!correctCheck) {
            incorrectCount += 1;
        }

        secret = holder.toString();
        if(secret.equals(phrase)) {
            System.out.println("the answer was " + phrase);
            System.out.println("You got it!");
        } else if (incorrectCount == 5){
            System.out.println("Too many wrong guesses, you lose");
            System.out.println("the answer was " + phrase);
        } else {
            gameLoop(phrase, secret, incorrectCount);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What is your phrase? ");

        String phrase = reader.readLine();
        StringBuilder secret = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
        if (phrase.charAt(i) == ' ') {
            secret.append(' ');
        } else {
            secret.append('*');
        }
        }
        int incorrectCount = 0;
        gameLoop(phrase, secret.toString(), incorrectCount);
    }
}