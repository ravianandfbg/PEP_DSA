import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void rotate(int[] a, int k) {
        // write your code here

        //balance k

        k = k % a.length;
        if (k < 0) {
            k = k + a.length;
        }

        //part 1
        reverse(a, 0, a.length - k - 1);

        //part 2
        reverse(a, a.length - k, a.length - 1);

        //all
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int[] a, int start_index, int end_index) {
        while (start_index < end_index) {
            int temp = a[start_index];
            a[start_index] = a[end_index];
            a[end_index] = temp;

            start_index++;
            end_index--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}