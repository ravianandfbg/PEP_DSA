import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      int[] arr = new int[n];
      for(int i = 0 ; i < n ; i++){
          arr[i] = scn.nextInt();
      }
      
      // Logic
      
      int oExc = 0 , oInc = 0;
      for(int i = 0 ; i < n ; i++){
          if(i == 0){
              oInc = arr[0]; 
          }
          else{
              int nInc = arr[i] + oExc;
              int nExc = Math.max(oExc , oInc);
              
              oExc = nExc;
              oInc = nInc;
          }
      }
      System.out.println(Math.max(oExc , oInc));

  }
}