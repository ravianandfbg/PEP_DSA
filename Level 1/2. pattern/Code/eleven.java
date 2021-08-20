import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int var=1;
        for(int row =0; row<n; row++)
        {
            for(int col = 0; col<=row; col++)
            {
                System.out.print(var + "	");
                var++;
            }
            System.out.println();
        }

    }
}