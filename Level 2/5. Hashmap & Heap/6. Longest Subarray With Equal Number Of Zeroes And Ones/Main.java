import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        
        // replace all 0's with -1
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = (arr[i] == 0) ? -1: arr[i]; 
        }
        
        // longest subarray sum having 0 logic
        HashMap<Integer , Integer> map = new HashMap<>(); // prefix sum vs first occurence(index)
        map.put(0 , -1);
        
        int ps = 0; // ps: prefix sum
        int oLen = 0; // oLen : overall Length
        
        for(int i = 0  ; i < arr.length ; i++){
            ps += arr[i];
            
            if(map.containsKey(ps) == false){
                // see ps 1st time
                map.put(ps , i);
            }
            else{
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
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
