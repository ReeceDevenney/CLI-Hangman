import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What is your phrase?");

        String phrase = reader.readLine();
        System.out.println(phrase);
    }
}