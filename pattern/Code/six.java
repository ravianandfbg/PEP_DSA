import java.util.*;

public class six {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n =scn.nextInt();
        
        int star = (n/2) + 1;
        int space = 1;
        
        for(int row=1; row<= n; row++)
        {
            //print star
            for(int st = 1; st <= star; st++)
            {
                System.out.print("*	");
            }
            
            //print space
            for(int sp = 1; sp <= space; sp++)
            {
                System.out.print("	");
            }
            
            //print star
            for(int st = 1; st <= star; st++)
            {
                System.out.print("*	");
            }
            
            //hit enter
            System.out.println();
            
            //manage star and space count
            if(row<=n/2)
            {
                space+=2;
                star--;
            }
            else
            {
                space-=2;
                star++;
            }

        }

    }
}