import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
     if(vidx == words.length){
         print(arr);
         return;
     }
    String word = words[vidx];
    for(int i = 0 ; i < arr.length; i++){
        for(int j = 0 ; j < arr[0].length ; j++){
            if( arr[i][j] == '-' || arr[i][j] == word.charAt(0) ){
                
                if(canPlaceHorizontal(arr,word,i,j)){
                    boolean vis[] = new boolean[word.length()];
                    placeHorizontal(arr,word,i,j,vis);
                    solution(arr,words,vidx+1);
                    unplaceHorizontal(arr,word,i,j,vis);
                }
                
                if(canPlaceVertical(arr,word,i,j)){
                    boolean vis[] = new boolean[word.length()];
                    placeVertical(arr,word,i,j,vis);
                    solution(arr,words,vidx+1);
                    unplaceVertical(arr,word,i,j,vis);
                }
            }
        }
    }
  }

   public static boolean canPlaceHorizontal(char[][] arr,String word,int i,int j){
       int wordPtr = 0 , placePtr = j;
       
       while(wordPtr < word.length()){
           if(placePtr == arr[0].length || arr[i][placePtr] == '+'){
               return false;
           }
           
           if(arr[i][placePtr] == '-' || arr[i][placePtr] == word.charAt(wordPtr)){
               placePtr++;
               wordPtr++;
           }else{
               return false;
           }
       }
       
       if((j == 0 || arr[i][j-1] == '+') && (placePtr == arr[0].length ||  arr[i][placePtr] == '+')){
           return true;
       }else{
           return false;
       }
   }

   public static void placeHorizontal(char[][] arr,String word,int i,int j,boolean[] vis){
       for(int idx = 0,placePtr = j ; idx < word.length() ; idx++,placePtr++){
           char ch = word.charAt(idx);
           if(arr[i][placePtr] == '-'){
               arr[i][placePtr] = ch;
               vis[idx] = true;
           }
       }
   }
   
   public static void unplaceHorizontal(char[][] arr,String word,int i,int j,boolean[] vis){
       for(int idx = 0,placePtr = j ; idx < word.length() ; idx++,placePtr++){
           if(vis[idx] == true){
               arr[i][placePtr] = '-';
           }
       }
   }
   
   public static boolean canPlaceVertical(char[][] arr,String word,int i,int j){
       int wordPtr = 0 , placePtr = i;
       
       while(wordPtr < word.length()){
           if(placePtr == arr.length || arr[placePtr][j] == '+'){
               return false;
           }
           
           if(arr[placePtr][j] == '-' || arr[placePtr][j] == word.charAt(wordPtr)){
               placePtr++;
               wordPtr++;
           }else{
               return false;
           }
       }
       
       if((i == 0 || arr[i-1][j] == '+') && (placePtr == arr.length ||  arr[placePtr][j] == '+')){
           return true;
       }else{
           return false;
       }
   }

   public static void placeVertical(char[][] arr,String word,int i,int j,boolean[] vis){
       for(int idx = 0,placePtr = i ; idx < word.length() ; idx++,placePtr++){
           char ch = word.charAt(idx);
           if(arr[placePtr][j] == '-'){
               arr[placePtr][j] = ch;
               vis[idx] = true;
           }
       }
   }
   
   public static void unplaceVertical(char[][] arr,String word,int i,int j,boolean[] vis){
       for(int idx = 0,placePtr = i ; idx < word.length() ; idx++,placePtr++){
           if(vis[idx] == true){
               arr[placePtr][j] = '-';
           }
       }
   }
  
  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
  
}