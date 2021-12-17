import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum % k vs first occurence(index)
        map.put(0 , -1);
        
        int ps = 0; // ps : prefix sum
        int oLen = 0; // oLen : overall length
        
        for(int i = 0 ; i < arr.length ; i++){
            ps += arr[i];
            
            int rem = ps % k;
            
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem) == false){
                // see remainder 1st time
                map.put(rem , i);
            }
            else{
                int len = i - map.get(rem);
                if(oLen < len){
                    oLen = len;
                }
            }
        }
        return oLen;
        
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
