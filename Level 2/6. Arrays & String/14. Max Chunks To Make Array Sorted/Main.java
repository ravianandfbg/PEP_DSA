import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        // write your code here   
        int maxReach = 0;
        int chunks = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            maxReach = Math.max(maxReach , arr[i]);
            
            if(maxReach == i){
                chunks++;
            }
        }
        return chunks;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}