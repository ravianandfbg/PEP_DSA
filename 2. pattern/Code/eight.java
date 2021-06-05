import java.util.*;

public class eight {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        for(int row=1; row<=n;row++)
        {
            for(int col=1; col<=n; col++)
            {
                if(row+col==n+1)
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