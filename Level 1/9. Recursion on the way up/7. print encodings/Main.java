import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        printEncodings(str , "");

    }

    public static void printEncodings(String str , String enc) {
        if(str.length() == 0){
            System.out.println(enc);
            return;
        }
        
        if(str.charAt(0) == '0'){
            return;
        }
        
        //single digit num
        char FirstChar = str.charAt(0);
        int num1 = Integer.parseInt(FirstChar+"");
        printEncodings(str.substring(1) , enc+(char)('a' + num1 - 1));
        
        if(str.length() > 1){
            //double digit num
            char secondChar = str.charAt(1);
            int num2 = Integer.parseInt(""+FirstChar+secondChar);
            if(num2 >= 10 && num2 <= 26){
                printEncodings(str.substring(2) , enc+(char)('a' + num2 - 1));
            }
        }
        
    }

}