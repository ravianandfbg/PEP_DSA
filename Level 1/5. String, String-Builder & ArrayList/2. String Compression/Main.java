import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		// write your code here
		String ans = str.charAt(0)+"";
		for(int idx = 1 ; idx < str.length(); idx++){
		    char curr = str.charAt(idx);
		    char prev = str.charAt(idx-1);
		    
		    if(curr != prev){
		        //explored a new chararcter
		        ans += curr;
		    }
		}

		return ans;
	}

	public static String compression2(String str){
		// write your code here
		String ans = str.charAt(0)+"";
		int count = 1;
		for(int idx = 1 ; idx < str.length(); idx++){
		    char curr = str.charAt(idx);
		    char prev = str.charAt(idx-1);
		    
		    if(curr != prev){
		        //explored a new character
		        if(count > 1){
		            ans += count;
		            count = 1;
		        }
		        ans += curr;
		    }
		        else{
		            count++;
		        }
		}
		if(count > 1){
		    ans += count;
		}

		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}