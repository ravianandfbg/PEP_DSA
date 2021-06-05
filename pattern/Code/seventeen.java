import java.util.*;

public class seventeen {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        int star = 1;
        int space = n/2;
        for(int row = 1; row<=n; row++)
        {
            for(int sp = 1; sp<=space; sp++)
            {
                
                //for 3rd row star
                if(row == n/2 + 1)
                {
                    System.out.print("*	");
                }
                else
                {
                    System.out.print("	");
                }
            }
                for(int st = 1; st<=star; st++)
                {
                    System.out.print("*	");
                }
                
                //hit enter
                System.out.println();
                
                
                //manage star count
                    if(row<=n/2)
                    {
                        star++;
                    }
                    else
                    {
                        star--;
                    }
                }
            }
        }