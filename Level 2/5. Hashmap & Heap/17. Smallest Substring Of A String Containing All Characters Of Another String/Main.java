import java.util.*;

public class Main {

	public static String solution(String s, String t){
		// write your code here
		if(t.length() > s.length()){
            return "";
        }
        HashMap<Character,Integer> t_map = new HashMap<>();
        
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            int oFreq = t_map.getOrDefault(ch , 0); // oFreq : old frequency
            t_map.put(ch , oFreq + 1);
        }
        
        int mc = 0; // mc : match count
        HashMap<Character,Integer> map = new HashMap<>(); // current_map
        int oLen = Integer.MAX_VALUE; // oLen : overall length
        int si = 0; // si :starting index
        int ei = -1; // ei : ending index
        
        int i = -1 , j = -1;
        
        while(i < s.length() - 1){
            // aquire
            while(i < s.length() - 1 && mc < t.length()){
                i++;
                
                // aquire its character
                char ch = s.charAt(i);
                int oFreq = map.getOrDefault(ch , 0);
                map.put(ch , oFreq + 1);
                
                // impact of aquired character on match count
                if(map.getOrDefault(ch , 0) <= t_map.getOrDefault(ch , 0)){
                    mc++;
                }
            }
            
            // release
            while(j < i && mc == t.length()){
                int len = i - j; // i - (j+1) + 1
                
                if(len < oLen){
                    oLen = len;
                    si = j + 1;
                    ei = i;
                }
                j++;
                
                // release jth character
                char ch = s.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    int oFreq = map.get(ch);
                    map.put(ch , oFreq - 1);
                }
                
                // impact of released character on match count
                if(map.getOrDefault(ch , 0) < t_map.getOrDefault(ch , 0)){
                    mc--;
                }
            }
        }
        return s.substring(si , ei + 1);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String t = scn.next();
		System.out.println(solution(s,t));
	}

}
