import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        int res[] = allIndices(arr, x, 0, 0);

        if (res.length != 0) {
            for (int val: res) {
                System.out.println(val);
            }
        }
        System.out.println();
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) { 
        // write ur code here
        if(idx == arr.length){
            int[] base = new int[fsf];
            return base;
        }
        int res[];
        if(arr[idx] == x){
            res = allIndices(arr, x, idx+1, fsf+1); //fsf = frequency so far
            res[fsf] = idx;
        }
        else{
            res = allIndices(arr, x, idx+1, fsf);
        }
        return res;
    }

}