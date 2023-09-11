import java.io.*;
import java.util.Objects;

public class Main {

    static void gameLoop(String phrase, String secret, int incorrectCount) throws IOException {
        System.out.println(secret);
        System.out.println(incorrectCount + "/5 incorrect guesses");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Guess a letter: ");

        String guess = reader.readLine();
        String holder = "";
        boolean correctCheck = false;

        for (int i = 0; i < phrase.length(); i++) {
            if(secret.charAt(i) == ' ') {
                holder = holder + ' ';
            } else if(secret.charAt(i) != '*') {
                holder = holder + secret.charAt(i);
            } else if (phrase.charAt(i) == guess.charAt(0)) {
                holder = holder + guess;
                correctCheck = true;
            } else {
                holder = holder + '*';
            }
        }

        if(!correctCheck) {
            incorrectCount += 1;
        }

        secret = holder;
        if(secret.equals(phrase)) {
            System.out.println("the answer was " + phrase);
            System.out.println("You got it!");
        } else if (incorrectCount == 5){
            System.out.println("Too many wrong guesses, you lose");
        } else {
            gameLoop(phrase, secret, incorrectCount);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What is your phrase?");

        String phrase = reader.readLine();
        String secret = "";
        for (int i = 0; i < phrase.length(); i++) {
        if (phrase.charAt(i) == ' ') {
            secret =  secret + ' ';
        } else {
            secret = secret + '*';
        }
        }
        int incorrectCount = 0;
        gameLoop(phrase, secret, incorrectCount);
    }
}