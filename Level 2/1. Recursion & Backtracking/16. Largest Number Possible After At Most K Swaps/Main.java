import java.io.*;
import java.util.*;

public class Main {

	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		if(k == 0){
		    return;
		}
		
		for(int i = 0 ; i < str.length() ; i++){
		    for(int j = i+1 ; j < str.length() ; j++){
		        String newStr = swap(str , i , j);
		        
		        if(Integer.parseInt(newStr) > Integer.parseInt(max)){
		            max = newStr;
		        }
		        
		        findMaximum(newStr , k-1);
		    }
		}
	}
	
	public static String swap(String str , int i , int j){
	    StringBuilder sb = new StringBuilder(str);
	    char iCh = sb.charAt(i);
	    char jCh = sb.charAt(j);
	    
	    sb.setCharAt(i , jCh);
	    sb.setCharAt(j , iCh);
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}