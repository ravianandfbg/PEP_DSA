import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int[] lmax = new int[arr.length]; // lmax : left max
        int[] rmin = new int[arr.length + 1]; // rmin : right minimum
        
        lmax[0] = arr[0];
        
        for(int i = 1 ; i < arr.length ; i++){
            lmax[i] = Math.max(lmax[i - 1] , arr[i]);
        }
        
        rmin[arr.length] = Integer.MAX_VALUE;
        
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            rmin[i] = Math.min(rmin[i + 1] , arr[i]);
        }
        
        int chunks = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(lmax[i] <= rmin[i + 1]){
                chunks++;
            }
        }
        return chunks;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}