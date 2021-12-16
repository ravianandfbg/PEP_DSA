import java.util.*;

public class Main {
	
	public static void solution(int[] arr, int k){
		//write your code here
		HashMap<Integer , Integer> map = new HashMap<>();
		
		for(int val : arr){
		    int rem = val % k;
		    
		    int nf = map.getOrDefault(rem , 0) + 1; // nf : new frequency
		    map.put(rem , nf);
		}
		
		boolean ans = true;
		
		for(int rem : map.keySet()){
		    int freq = map.get(rem);
		    
		    if((k % 2 == 0 && rem == k/2) || rem == 0){
		        if(freq % 2 != 0){
		            ans = false;
		            break;
		        }
		    }
		    else{
		        int freq2 = map.getOrDefault(k-rem , -1);
		        
		        if(freq2 == -1 || freq != freq2){
		            ans = false;
		            break;
		        }
		    }
		}
		System.out.println(ans);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}
	
}
