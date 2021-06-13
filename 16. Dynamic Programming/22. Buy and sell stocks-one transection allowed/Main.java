import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args)  {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int price[] = new int[n];
    for (int i = 0 ; i < n ; i++) {
      price[i] = scn.nextInt();
    }
    
    System.out.println(BuyAndSellOneTrans(price));
  }
  
  public static int BuyAndSellOneTrans(int[] price){
      
      int Bestbuy = price[0] , maxProfit = 0;
      
      for(int i = 1 ; i < price.length ; i++){
          if(price[i] < Bestbuy){
              Bestbuy = price[i];
          }
          else{
              if(price[i] - Bestbuy > maxProfit){
                  maxProfit = price[i] - Bestbuy;
              }
          }
      }
      return maxProfit;
  }

}