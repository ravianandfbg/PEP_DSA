import java.util.*;

public class Main {

    public static int solution(int[] arr, int k){
        // write your code here
        
         int i = -1;
        int j = -1;
        
        int count_zero = 0;
        int ans = 0;
        
        while(i < arr.length - 1){
            
            // acquire
            while(i < arr.length - 1 && count_zero <= k){
                i++;
                
                if(arr[i] == 0){
                    count_zero++;
                }
                
                if(count_zero <= k){
                    int len = i - j;
                    ans = Math.max(len , ans);
                }
            }
            
            // release
            while( j < i){
                j++;
                
                if(arr[j] == 0){
                    count_zero--;
                    break;
                }
            }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
	}

}
