import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        String inp = scn.nextLine();
        
        System.out.println(getKPC(inp));
    }
    
    static String keypad[] = {".;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};
    
    public static ArrayList < String > getKPC(String str) {
        if(str.length() == 0){
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1); //ros : Rest of String
        
        ArrayList < String > rres = getKPC(ros); //rres : Recursive result
        int idx = Integer.parseInt(ch + "");
        String word = keypad[idx];
        
        ArrayList < String > myList = new ArrayList < > ();
        
        for(int i = 0; i < word.length(); i++){
            for(String temp : rres){
                myList.add(word.charAt(i) + temp);
            }
        }
        return myList;
    }

}