
import java.io.*;

class MatrixMultiplication {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int a[][] = new int[10][10];
        int b[][] = new int[10][10];
        int c[][] = new int[10][10];

        int r1, c1, r2, c2;

        System.out.println("Enter rows and columns of first matrix:");
        r1 = Integer.parseInt(br.readLine());
        c1 = Integer.parseInt(br.readLine());

        System.out.println("Enter rows and columns of second matrix:");
        r2 = Integer.parseInt(br.readLine());
        c2 = Integer.parseInt(br.readLine());

        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible.");
            return;
        }

        System.out.println("Enter first matrix elements:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = Integer.parseInt(br.readLine());
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                c[i][j] = 0;

                for (int k = 0; k < c1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Resultant matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

