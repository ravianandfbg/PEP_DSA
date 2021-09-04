import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//write your code here
// 		op : original pattern
		if(str.length() == 0 && pattern.length() == 0){
		    HashSet<Character> set = new HashSet<>();
		    for(int i = 0 ; i < op.length() ; i++){
		        char c = op.charAt(i);
		        if(set.contains(c) == false){
		            set.add(c);
		            System.out.print(c+" -> "+map.get(c)+", ");
		        }
		    }
		        System.out.println(".");
		        return;
		    }
		    if(pattern.length() == 0){
		        return;
		}
		
		
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1); // rop : rest of pattern
		
		if(map.containsKey(ch)){
		    String mappedStr = map.get(ch);
    int k = mappedStr.length();
    if(k > str.length()){
        return;
    }
    String left = str.substring(0 , k);
    String right = str.substring(k);
    if(mappedStr.equals(left)){
        solution(right , rop , map , op);
    }
		    
		}
		else{
		    for(int i = 0 ; i < str.length() ; i++){
		        String left = str.substring(0 , i + 1);
		        String right = str.substring(i + 1);
		        map.put(ch , left);
		        solution(right , rop , map , op);
		        map.remove(ch);
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}