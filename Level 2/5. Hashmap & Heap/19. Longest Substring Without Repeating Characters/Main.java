import java.util.*;
 import java.util.Scanner;
 
 public class Main {
 	 public static int lengthOfLongestSubstring(String s) {
 	 //Write your code here
 	 HashMap<Character,Integer> map = new HashMap<>();
        int oLen = 0; // oLen : overall length
        
        int i = -1;
        int j = -1;
        
        while(i < s.length() - 1){
            // acquire
            while(i < s.length() - 1){
                
                i++;
                
                char ch = s.charAt(i);
                int oFreq = map.getOrDefault(ch , 0);
                map.put(ch , oFreq + 1);
                
                if(map.get(ch) > 1){
                    break;
                }
                else{
                    int len = i - j;
                    oLen = Math.max(len , oLen);
                }
            }
            // release
            while(j < i){
                j++;
                
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    int oFreq = map.get(ch);
                    map.put(ch , oFreq - 1);
                    break;
                }
            }
        }
        return oLen;
 	 	 
 	 	 
 	 }
 	 //Don't make any changes here.
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 String str = s.next();
 	 	 System.out.println(lengthOfLongestSubstring(str));
 
 	 }
 
 }