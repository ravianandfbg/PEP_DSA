import java.util.*;

public class seven {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        for(int row = 1; row<=n; row++)
        {
            for(int col = 1; col<=n; col++)
            {
                if(row==col)
                {
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