import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int lo = 0; //lo : low index
        int hi = arr.length - 1; //hi : high index
        int ceil = 0;
        int floor = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (data < arr[mid]) {
                hi = mid - 1;
                ceil = arr[mid];
            } else if (data > arr[mid]) {
                lo = mid + 1;
                floor = arr[mid];
            } else {
                ceil = arr[mid];
                floor = arr[mid];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }

}