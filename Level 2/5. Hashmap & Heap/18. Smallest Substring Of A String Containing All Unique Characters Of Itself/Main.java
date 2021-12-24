import java.util.*;

public class Main {

	public static int solution(String str){
		// write your code here
		
		HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            hs.add(str.charAt(i));
        }
        
        HashMap<Character,Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        
        int oLen = Integer.MAX_VALUE; // oLen : overall length
        int si = 0; // si : starting index
        int ei = -1; // ei : ending index
        
        while(i < str.length() - 1){
            // aquire
            while(i < str.length() -1 && map.size() <hs.size()){
                i++;
                
                char ch = str.charAt(i);
                int oFreq = map.getOrDefault(ch , 0); // oFreq : old frequency
                map.put(ch , oFreq + 1);
            }
            
            // release
            while(j < i && map.size() == hs.size()){
                int len = i - j;
                
                if(len < oLen){
                    oLen = len;
                    si = j + 1;
                    ei = i;
                }
                j++;
                
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    int oFreq = map.get(ch);
                    map.put(ch , oFreq - 1);
                }
            }
        }
        return oLen;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
