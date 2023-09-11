import java.io.*;

public class Main {
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
        System.out.println(secret);
    }
}