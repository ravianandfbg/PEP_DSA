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
        int fee = scn.nextInt();
        System.out.println(BuyAndSellStockInfinteTransactionWithTransactionFee(price,fee));
    }
    public static int BuyAndSellStockInfinteTransactionWithTransactionFee(int price[],int fee){
        
        //oBSP : old Buying State Profit
        //oSSP : old Selling State Profit
        int oBSP = -price[0] , oSSP = 0;
        
        for(int i = 1 ; i < price.length ; i++){
            int nBSP = Math.max(oBSP , oSSP - price[i]);
            int nSSP = Math.max(oSSP , price[i]-fee+oBSP);
            
            oBSP = nBSP;
            oSSP = nSSP;
        }
        
        return oSSP;
        
    }

}