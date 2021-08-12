import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        System.out.println(gss(str)); 

    }

    public static ArrayList < String > gss(String str) {
        if(str.length() == 0){
            //empty string
            ArrayList < String > bl = new ArrayList < > (); //bl : Base List
            bl.add("");
            
            return bl;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1); //ros : rest of string
        
        ArrayList < String > rres = gss(ros); //rres : recursive result
        
        ArrayList < String > myList = new ArrayList < > (); //create my list
        
        for(String s : rres){
            myList.add(s);
        }
        
        for(String s : rres){
            myList.add(ch + s);
        }
        return myList;
    }

}