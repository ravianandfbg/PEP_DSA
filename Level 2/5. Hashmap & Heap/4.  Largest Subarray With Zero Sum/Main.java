import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		// write your code here
		
		HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum vs it's first occurence (index)
		
		int ps = 0; // ps : prefix sum
		int oLen = 0; // oLen : overall length
		
		map.put(0,-1); // initially put ps = 0 , idx = -1
		
		for(int i = 0 ; i < arr.length ; i++){
		    ps += arr[i];
		    
		    if(map.containsKey(ps) == false){
		        // see prefix sum(ps) first time. so add in map with index
		        map.put(ps , i);
		    }
		    else{
		        // if ps is already in map
		        int len = i - map.get(ps);
		        
		        if(oLen < len){
		            oLen = len;
		        }
		    }
		}
		return oLen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
