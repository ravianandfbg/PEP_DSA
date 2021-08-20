import java.util.*;

public class fifteen {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int star = 1;
        int space = n / 2;
        int val = 1;

        for (int row = 1; row <= n; row++) {
            
            //print space
            for (int sp = 1; sp <= space; sp++) {
                System.out.print("	");
            }
            
            //print star
            int cval = val;
            for (int st = 1; st <= star; st++) {
                System.out.print(cval + "	");


                if (st <= star / 2) {
                    cval++;
                } else {
                    cval--;
                }
            }
            //hit enter
            System.out.println();

            //manage star and space count
            if (row <= n / 2) {
                space--;
                star += 2;
                val++;
            } else {
                space++;
                star -= 2;
                val--;
            }
            
            
        }

    }
}