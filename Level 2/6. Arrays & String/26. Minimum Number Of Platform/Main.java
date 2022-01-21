// time : O(NLOGN)
// space : O(N)

import java.util.*;

public class Main {

  public static int findPlatform(int[] arr, int[] dep) {
    // write your code here
    Arrays.sort(arr);
    Arrays.sort(dep);
    
    int i = 0;
    int j = 0;
    int count = 0;
    int max = 0;
    
    while(i < arr.length && j < dep.length){
        if(arr[i] < dep[j]){
            count++;
            i++;
        }
        else{
            count--;
            j++;
        }
        max = Math.max(count , max);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int[] dep = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    for (int i = 0; i < n; i++) {
      dep[i] = scn.nextInt();
    }

    int plateforms = findPlatform(arr, dep);
    System.out.println(plateforms);
  }
}