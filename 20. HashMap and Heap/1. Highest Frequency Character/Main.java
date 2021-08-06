import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        HashMap<Character , Integer> hm = new HashMap<>();
        
        char hFCh = ' '; // hFCh : highest Frequency Character
        int hFreq = 0; // hFreq : highest Frequency
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            
            if(hm.containsKey(ch) == true){
                hm.put(ch , hm.get(ch) + 1);
            }
            else{
                hm.put(ch , 1);
            }
            
            if(hm.get(ch) > hFreq){
                hFreq = hm.get(ch);
                hFCh = ch;
            }
        }
        System.out.println(hFCh);
    }

}