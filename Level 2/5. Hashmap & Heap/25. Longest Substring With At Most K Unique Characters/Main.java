import java.util.*;

public class Main {

	public static int solution(String s, int k) {
		// write your code here
		
		HashMap<Character,Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;
        int ans = 0;

        while(i < s.length() - 1){

            // acquire
            while(i < s.length() - 1 && map.size() <= k){
                i++;

                char ch = s.charAt(i);
                int nFreq = map.getOrDefault(ch , 0) + 1; // nFreq : new frequency
                map.put(ch , nFreq);

                if(map.size() <= k){
                    // valid ans
                    int len = i - j;
                    ans = Math.max(len , ans);
                }
            }

            // release
            while(j < i){
                j++;

                char ch = s.charAt(j);
                if(map.get(ch) == 1){
                    // valid 
                    map.remove(ch);
                    break;
                }
                else{
                    // invalid
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
