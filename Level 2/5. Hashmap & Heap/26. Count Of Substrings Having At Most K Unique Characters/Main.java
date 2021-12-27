import java.util.*;

public class Main {

	public static int solution(String str, int k) {
		// write your code here
		HashMap<Character,Integer> map = new HashMap<>();
		
		int i = -1;
		int j = -1;
		int count = 0;
		
		while(i < str.length() - 1){
		    
		    // acquire
		    while(i < str.length() - 1 && map.size() <= k){
		        i++;
		        
		        char ch = str.charAt(i);
		        int nFreq = map.getOrDefault(ch , 0) + 1; // nFreq : new frequency
		        map.put(ch , nFreq);
		        
		        if(map.size() <= k){
		            count += (i - j);
		        }
		    }
		    
		    // release
		    while(j < i && map.size() == k + 1){
		        j++;
		        
		        char ch = str.charAt(j);
		        
		        if(map.get(ch) == 1){
		            map.remove(ch);
		            
		            // valid
		            count += (i - j);
		            break;
		        }
		        
		        else{
		           int nFreq = map.get(ch) - 1;
		            map.put(ch , nFreq);
		        }
		    }
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
