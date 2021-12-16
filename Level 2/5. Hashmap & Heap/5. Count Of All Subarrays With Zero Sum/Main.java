import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		// write your code here
		
		HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum(ps) vs freq
		map.put(0 , 1); // here ps = 0 ; freq of 0 = 1
		
		int count = 0;
		int ps = 0; // ps : prefix sum
		
		
		for(int i = 0 ; i < arr.length ; i++){
		     ps += arr[i]; //  ps : prefix sum
		    
		    if(map.containsKey(ps) == false){
		        // if ps see 1st time
		        map.put(ps , 1);
		    }
		    else{
		        int oFreq = map.get(ps); // oFreq : old frequency
		         count += oFreq;
		        
		        map.put(ps , oFreq + 1);
		    }
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
