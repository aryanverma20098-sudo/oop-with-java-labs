
import java.rmi.*;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            RemoteCalc c = (RemoteCalc)
                    Naming.lookup("rmi://localhost/CalcService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition = " + c.addition(a, b));
            System.out.println("Subtraction = " + c.subtraction(a, b));
            System.out.println("Multiplication = " + c.multiply(a, b));

            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
