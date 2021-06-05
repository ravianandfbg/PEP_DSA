import java.util.*;

public class sixteen {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        
        int n = scn.nextInt();
        
        int star=1;
        int space=2*n-3;
        
        for(int row=1;row<=n;row++)
        {
            int val=1;
            
            //print star
            for(int st=1;st<=star;st++)
            {
                System.out.print(val + "	");
                val++;
            }
            
            //print space
            for(int sp = 1; sp<=space; sp++)
            {
                System.out.print("	");
            }
            
            //manage star and val count
            if(row==n)
            {
                star--;
                val--;
            }
            
            //print decreasing val
            for(int st = 1; st <= star; st++)
            {
                val--;
                System.out.print(val + "	");
            }
            
            //manage star and space count
            star++;
            space-=2;
            
            //hit enter
            System.out.println();
        }

    }
}