import java.util.*;

public class twelve {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int a=0;
        int b=1;
        
        for(int row = 0; row<n; row++)
        {
            for(int col = 0; col<=row;col++)
            {
                System.out.print(a+"	");
                int c = a+b;
                a=b;
                b=c;
            }
            System.out.println();
        }

    }
}