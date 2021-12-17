import java.util.*;

public class Main {

	public static int solution(int[] arr, int target){
		// write your code here
		
		HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum vs freq
		map.put(0 , 1);
		
		int ps = 0; // ps : prefix sum
		int count = 0;
		
		for(int i = 0 ; i < arr.length ; i++){
		    ps += arr[i];
		    
		    if(map.containsKey(ps - target) == true){
		        int oFreq = map.get(ps - target);
		        count += oFreq;
		    }
		    int nFreq = map.getOrDefault(ps , 0) + 1; // nFreq : new freq
		    map.put(ps , nFreq);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
