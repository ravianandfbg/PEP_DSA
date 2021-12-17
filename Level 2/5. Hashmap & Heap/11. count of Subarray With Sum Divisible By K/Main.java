import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum % k vs freq
        map.put(0 , 1);
        
        int ps = 0; // ps : prefix sum
        int count = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            ps += arr[i];
            
            int rem = ps % k;
            
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem) == true){
                int oFreq = map.get(rem); // oFreq : old freq
                count += oFreq;
                map.put(rem , oFreq + 1);
            }
            else{
                map.put(rem , 1);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
