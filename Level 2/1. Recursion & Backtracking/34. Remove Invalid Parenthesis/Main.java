import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		//write your code here
		if(minRemoval == 0){
		    if(isValid(str) && ans.contains(str) == false){
		        System.out.println(str);
		        ans.add(str);
		    }
		    return;
		}
		
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0 ; i < str.length() ; i++){
		    sb.deleteCharAt(i);
		    solution(sb.toString() , minRemoval - 1 , ans);
		    sb.insert(i , str.charAt(i));
		}
	}
	
	public static boolean isValid(String str){
		Stack<Character> st = new Stack<>();
		
		for(int i = 0 ; i < str.length() ; i++){
		    char ch = str.charAt(i);
		    
		    if(ch == '('){
		        st.push(ch);
		    }
		    else if(ch == ')'){
		        if(st.size() == 0 || st.peek() == ')'){
		            st.push(ch);
		            return false;
		        }
		        else if(st.peek() == '('){
		            st.pop();
		        }
		    }
		}
		return st.size() == 0;
	}

	public static int getMin(String str){
		//write your code here
		Stack<Character> st = new Stack<>();
		
		for(int i = 0 ; i < str.length() ; i++){
		    char ch = str.charAt(i);
		    
		    if(ch == '('){
		        st.push(ch);
		    }
		    else if(ch == ')'){
		        if(st.size() == 0 || st.peek() == ')'){
		            st.push(ch);
		        }
		        else if(st.peek() == '('){
		            st.pop();
		        }
		    }
		}
		return st.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
	}
		
}