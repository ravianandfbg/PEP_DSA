// Time : O(n + m)                  Space : O(1)

import java.util.*;
import java.io.*;

public class Main {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] arr1,int[] arr2) {
        //write your code here
        int n = arr1.length;
        int m = arr2.length;
        
        ArrayList<Integer> ans = new ArrayList<>(); // union
        
        int i = 0;
        int j = 0;
        
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(ans.size() == 0){
                    ans.add(arr1[i]);
                }
                else if(ans.get(ans.size() - 1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                i++;
            }
            else{
                if(ans.size() == 0){
                    ans.add(arr2[j]);
                }
                else if(ans.get(ans.size() - 1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while(i < n){
            if(ans.get(ans.size() - 1) != arr1[i]){
                ans.add(arr1[i]);
            }
            i++;
            
        }
        
        while(j < m){
            if(ans.get(ans.size() - 1) != arr2[j]){
                ans.add(arr2[j]);
                
            }
            j++;
        }
        
        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}