import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        //for n1 number
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        
        for(int i = 0; i < n1; i++)
        {
            arr1[i] = scn.nextInt();
        }
        
        //for n2 number
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        
        for(int i = 0; i < n2; i++)
        {
            arr2[i] = scn.nextInt();
        }
        
        int len = Math.max(n1,n2) + 1; 
        int[] ans = new int[len];
        
        int carry = 0;
        int i = arr1.length - 1; //it will go to last index of arr1
        int j = arr2.length - 1; //it will go to last index of arr2
        int k = ans.length - 1;  //it will go to last index of ans
        
        while(i>=0 || j>=0 || k>=0)
        {
            int sum = 0;
            if(i>=0)
            {
                sum = sum + arr1[i];
            }
            if(j >= 0)
            {
                sum = sum + arr2[j];
            }
            
            sum = sum + carry;
            
            int rem = sum % 10; //find remainder
            int quo = sum / 10; //find quotient
            ans[k] = rem;
            carry = quo;
            
            i--;
            j--;
            k--;
        }
        //for example the answer 0123. so we can't print 0123, we have to print 123.            that's why we are taking if condition
        
        if(ans[0] != 0)
        {
            System.out.println(ans[0]);
        }
        
        //here we have taken m=1 because we have already take the value ans[0] value.           so we are taking m=1 in this case
        
        for(int m = 1; m < ans.length; m++)
        {
            System.out.println(ans[m]);
        }
        
    }

}