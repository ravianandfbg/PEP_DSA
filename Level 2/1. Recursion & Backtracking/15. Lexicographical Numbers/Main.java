import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here
		for(int i = 1 ; i <= 9 ; i++){
		    solve(i , n);
		}
	}
	
	public static void solve(int curr_num , int n){
	    if(curr_num > n){
	        return;
	    }
	    
	    else{
	        System.out.println(curr_num);
	        
	        for(int digit = 0 ; digit <= 9 ; digit++){
	            int newCurr_num = (curr_num * 10) + digit ;
	            
	            if(newCurr_num <= n){
	                solve(newCurr_num , n);
	            }
	        }
	    }
	}
	
}