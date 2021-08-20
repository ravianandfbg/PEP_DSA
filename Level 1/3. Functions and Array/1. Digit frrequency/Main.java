import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        // write code here

        int ans = 0;
        while (n > 0) {
            
            //last didgit extract
            int last_digit = n % 10;
            
            //last digit remove
            n = n / 10;
            
            if (last_digit == d) {
                
                //if the value is same then ans will ++ otherwise back the                      loop
                ans++;
            }
        }
        return ans;
    }
}