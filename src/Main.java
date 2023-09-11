import java.io.*;
import java.util.Objects;

public class Main {

    static void gameLoop(String phrase, String secret) throws IOException {
        System.out.println(secret);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Guess a letter: ");

        String guess = reader.readLine();
        String holder = "";

        for (int i = 0; i < phrase.length(); i++) {
            if(secret.charAt(i) == ' ') {
                holder = holder + ' ';
            } else if(secret.charAt(i) != '*') {
                holder = holder + secret.charAt(i);
            } else if (phrase.charAt(i) == guess.charAt(0)) {
                holder = holder + guess;
            } else {
                holder = holder + '*';
            }
        }
        secret = holder;
        if(secret.equals(phrase)) {
            System.out.println("the answer was " + phrase);
            System.out.println("You got it!");
        } else {
            gameLoop(phrase, secret);
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
        gameLoop(phrase, secret);
    }
}