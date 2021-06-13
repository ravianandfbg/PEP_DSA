import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++){
            price[i] = scn.nextInt();
        }
        
        System.out.println(BuyAndSellTwoTrans(price));
        
    }
    
    public static int BuyAndSellTwoTrans(int[] price){
        int pBD[] = profitConsideringBuyingDay(price); // pBD : profitConsidering Buying Day
        int pSD[] = profitConsideringSellingDay(price); // pSD : profitConsidering Selling Day
        
        // cummulative maximum of Buying Day
        for(int i = price.length-2 ; i >= 0 ; i--){
            pBD[i] = Math.max(pBD[i] , pBD[i+1]);
        }
        
        // cummulative maximum of Selling Day
        for(int i = 1 ; i < price.length ; i++){
            pSD[i] = Math.max(pSD[i] , pSD[i-1]);
        }
        
        int omax = 0; // omax : overall max
        for(int i = 0 ; i < price.length ; i++){
            omax = Math.max(omax , pBD[i]+pSD[i]);
        }
        return omax;
        
    }
    
    
    // Buying Day
    public static int[] profitConsideringBuyingDay(int[] price){
        int res[] = new int[price.length];
        
        int bestSell = price[price.length-1];
        
        for(int i = price.length-2 ; i >= 0 ; i--){
            if(price[i] > bestSell){
                bestSell = price[i];
            }
            else{
                res[i] = bestSell - price[i];
            }
        }
        return res;
        
    }
    
    
    //Selling Day
    public static int[] profitConsideringSellingDay(int[] price){
        int res[] = new int[price.length];
        int bestBuy = price[0];
        
        for(int i = 1 ; i < price.length ; i++){
            if(price[i] < bestBuy){
                bestBuy = price[i];
            }
            else{
                res[i] = price[i] - bestBuy;
            }
        }
        return res;
    }

}