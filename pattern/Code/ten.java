import java.util.*;

public class ten {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        n--;

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                if (row + col == n / 2) {
                    System.out.print("*	");
                } else if (row + col == (n + n / 2)) {
                    System.out.print("*	");
                } else if (row - col == n / 2) {
                    System.out.print("*	");
                } else if (col - row == n / 2) {
                    System.out.print("*	");
                }
                else
                {
                    System.out.print("	");
                }
            }
            System.out.println();
        }

    }
}