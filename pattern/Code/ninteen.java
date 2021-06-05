import java.util.*;

public class ninteen {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        for(int row = 1; row <= n; row++)
        {
            for(int col = 1; col <= n; col++)
            {
                if(row==1)
                {
                    if(col <= n/2 + 1 || col == n)
                    {
                        System.out.print("*	");
                    }
                    else
                    {
                        System.out.print("	");
                    }
                }
                else if(row <= n/2)
                {
                    if(col == n/2+1 || col == n)
                    {
                        System.out.print("*	");
                    }
                    else
                    {
                        System.out.print("	");
                    }
                }
                else if(row == n/2 + 1)
                {
                        System.out.print("*	");
                }
                else if(row<n)
                {
                    if(col == 1 || col == n/2 + 1)
                    {
                        System.out.print("*	");
                    }
                    else
                    {
                        System.out.print("	");
                    }
                }
                else
                {
                    if(col == 1 || col >= n/2 + 1)
                    {
                        System.out.print("*	");
                    }
                    else
                    {
                        System.out.print("	");
                    }
                }
            }
            System.out.println();
        }

    }
}