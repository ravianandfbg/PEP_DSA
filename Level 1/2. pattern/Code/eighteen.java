import java.util.*;

public class eighteen {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        int star = n;
        int space = 0;

        for (int row = 1; row <= n; row++) {
            
            //print space
            for (int sp = 1; sp <= space; sp++) {
                System.out.print("	");
            }
            
            //print star
            for (int st = 1; st <= star; st++) {
                if (row > 1 && row <= n / 2 && st > 1 && st < star) {
                    System.out.print("	");
                } else {
                    System.out.print("*	");
                }
            }

            //hit enter
            System.out.println();

            //manage space and star 
            if (row <= n / 2) {
                space++;
                star -= 2;
            } else {
                space--;
                star += 2;
            }
        }

    }
}