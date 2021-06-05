import java.util.*;

public class two {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int star = n;
        for (int row = 1; row <= n; row++) {
            for (int st = 1; st <= star; st++) {
                System.out.print("*	");
            }
            System.out.println();
            star--;
        }

    }
}