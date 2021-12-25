import java.util.*;

public class Main {

	public static int solution(String s, int k){
		// write your code here
		HashMap<Character,Integer> map = new HashMap<>();
		
		int i = -1;
		int j = -1;
		int ans = -1;
		
		while(i < s.length() - 1){
		    
		    // acquire
		    while(i < s.length() - 1){
		        i++;
		        
		        char ch = s.charAt(i);
		        int nFreq = map.getOrDefault(ch , 0) + 1;
		        map.put(ch , nFreq);
		        
		        if(map.size() == k){
		            // valid ans
		            int len = i - j;
		            ans = Math.max(len , ans);
		        }
		        else if(map.size() == k + 1){
		            // invalid ans
		            break;
		        }
		    }
		    // release
		    while(j < i && map.size() == k + 1){
		        j++;
		        
		        char ch = s.charAt(j);
		        
		        if(map.get(ch) == 1){
		            map.remove(ch);
		        }
		        else{
		            int nFreq = map.get(ch) - 1;
		            map.put(ch , nFreq);
		        }
		        
		    }
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
