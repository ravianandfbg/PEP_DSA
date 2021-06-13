import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int price[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            price[i] = scn.nextInt();
        }
        
        System.out.println(BuyAndSellStockInfinteTransactionWithCooldown(price));
    }
    public static int BuyAndSellStockInfinteTransactionWithCooldown(int price[]){
        
        //oBSP : old Buying State Profit
        //oSSP : old Selling State Profit
        //oCSP : old Cooldown State Profit
        int oBSP = -price[0] , oSSP = 0 , oCSP = 0;
        
        for(int i = 1 ; i < price.length ; i++){
            int nBSP = Math.max(oBSP , oCSP - price[i]);
            int nSSP = Math.max(oSSP , price[i]+oBSP);
            int nCSP = oSSP;
            
            oBSP = nBSP;
            oSSP = nSSP;
            oCSP = nCSP;
        }
        
        return oSSP;
        
    }

}