import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		//write your code here
		StringBuilder res = new StringBuilder();
		
		for(int idx = 0; idx < str.length(); idx++){
		    char ch = str.charAt(idx);
		    
		    //for upper case
		    if(ch >= 'A' && ch <= 'Z'){
		        //ch : upper casen-> lower case
		        char lc = (char)((ch - 'A') + 'a'); //lc = lower case
		        res.append(lc);
		    }
		    else if(ch >= 'a' && ch <= 'z'){
		        //ch : lower case -> upper case
		        char uc = (char)((ch - 'a') + 'A'); //uc = upper case
		        res.append(uc);
		    }
		}
		

		return res.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}