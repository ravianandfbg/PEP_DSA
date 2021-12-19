import java.util.*;

public class Main {

	public static boolean wordPattern(String pattern, String str) {
		// write your code here
		
		HashSet<String> used = new HashSet<>();
		HashMap<Character , String> map = new HashMap<>();
		String[] arr = str.split(" ");
		
		for(int i = 0 ; i < pattern.length() ; i++){
		    char ch = pattern.charAt(i);
		    String word = arr[i];
		    
		    if(map.containsKey(ch) == false){
		        // see character 1st time
		        if(used.contains(word) == true){
		            // if word used before(or that word already in hashset)
		            return false;
		        }
		        // if we see word 1st time
		        map.put(ch , word);
		        used.add(word);
		    }
		    else{
		        String pmWord = map.get(ch); // pmWord : previously mapped word
		        
		        if(pmWord.equals(word) == false){
		            return false;
		        }
		    }
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}
