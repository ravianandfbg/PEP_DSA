import java.io.*;
import java.util.*;

public class Main {
    
    //check palindrome
    public static boolean isPalindrome(String ss){
        int low = 0;
        int high = ss.length()-1;
        
        while(low < high){
            if(ss.charAt(low) != ss.charAt(high)){
                return false;
            }
                low++;
                high--;
        }
        return true;
    }
    
    //for substring
	public static void solution(String str){
		//write your code here
		int n = str.length();
		for(int i = 0; i <= n-1 ; i++){
		    for(int j = i+1 ; j <= n ; j++){
		        String ss = str.substring(i,j);
		        
		        if(isPalindrome(ss) == true){
		            System.out.println(ss);
		        }
		    }
		}
		
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}