import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++){
            price[i] = scn.nextInt();
        }
        
        System.out.println(BuyAndSellInfiniteTrans(price));
    }
    
    public static int BuyAndSellInfiniteTrans(int[] price){
        
        // bp : Buying point
        // sp : Selling point
        
        int bp = 0 , sp = 0 , profit = 0;
        
        for(int day = 1 ; day < price.length ; day++){
            if(price[day] < price[day-1]){
                profit += price[sp] - price[bp];
                bp = sp = day;
            }
            else{
                sp++;
                // sp = day;
            }
        }
        profit += price[sp] - price[bp];
        
    return profit;
    }

}