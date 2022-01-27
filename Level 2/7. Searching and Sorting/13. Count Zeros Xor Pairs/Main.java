// time : O(NlogN)           space : O(1)


import java.util.*;
import java.io.*;

public class Main {
  public static int countPairs(int[]arr) {
    //write your code here
    HashMap<Integer,Integer> map = new HashMap<>();
    
    for(int elem : arr){
        if(map.containsKey(elem) == false){
            map.put(elem , 1);
        }
        else{
            int nFreq = map.get(elem) + 1;
            map.put(elem , nFreq);
        }
    }
    int count = 0;
    
    for(int key : map.keySet()){
        int c = map.get(key);
        count += (c * (c - 1) / 2);
    }
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}