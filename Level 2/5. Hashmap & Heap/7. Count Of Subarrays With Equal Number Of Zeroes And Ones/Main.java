import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        
        // replace all 0's with -1
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = (arr[i] == 0) ? -1 : arr[i];
        }
        
        // count of all subarrays with zero sum
        HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum vs frequency
        map.put(0 , 1); // 0 is ps and 1 is freq of 0
        
        int count = 0;
        int ps = 0; // ps : prefix sum
        
        for(int i = 0 ; i < arr.length ; i++){
            ps += arr[i];
            
            if(map.containsKey(ps) == false){
                // if we see ps 1st time
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
