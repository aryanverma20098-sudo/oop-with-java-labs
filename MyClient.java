
import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter message:");
        String msg = keyboard.readLine();

        out.println(msg);

        String reply = in.readLine();
        System.out.println("Reply from server: " + reply);

        s.close();
    }
}
