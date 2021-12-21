import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer , Integer> map = new HashMap<>(); // ans vs how many rabbits
        
        for(int i = 0 ; i < arr.length ; i++){
            // if we see answers 1st time then 0, otherwise answers ke same wali value
            int oFreq = map.getOrDefault(arr[i] , 0); // oFreq : old frequency
            map.put(arr[i] , oFreq + 1);
        }
        int ans = 0;
        
        for(int key : map.keySet()){
            int gs = key + 1; // gs : group size
            int tr = map.get(key); // tr : total rabbits
            
            ans += Math.ceil(tr * 1.0 / gs) * gs;
        }
        return ans;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
