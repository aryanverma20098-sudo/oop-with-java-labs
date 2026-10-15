
import java.util.Scanner;

public class AdditionDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        AdditionBean bean = new AdditionBean();

        bean.setNum1(a);
        bean.setNum2(b);

        System.out.println("Addition = " + bean.getSum());

        sc.close();
    }
}

