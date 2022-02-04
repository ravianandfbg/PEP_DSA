// Time : O(N log N)          space : O(1)

import java.util.*;
import java.io.*;

public class Main {

  public static int find(int[]arr, int n, int m) {
    //write your code here
    int ans = Integer.MAX_VALUE;
    Arrays.sort(arr);

    for (int i = 0 ; i <= n - m ; i++) {
      //window i to  i+m-1
      int minW = arr[i];
      int maxW = arr[i + m - 1];
      int gap = maxW - minW;

      ans = Math.min(ans, gap);
    }
    return ans;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    //input work
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int ans = find(arr, n, m);

    System.out.println(ans);
  }
}