import java.util.*;

public class one {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int star=1;
        
        //outer loop
        for (int row = 1; row <= n; row++) 
        {
             //print column star time    
            for (int end = 1; end <= star; end++)
            {

                System.out.print("*	");
            }
            //hit enter
        System.out.println();
        //increase stars
        star++;
        }
    }
}