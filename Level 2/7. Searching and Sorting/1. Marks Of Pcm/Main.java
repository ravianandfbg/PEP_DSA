// time : O(NlogN)      space : O(N)

import java.util.*;
import java.io.*;

public class Main {
    // code starts from here
    public static class ReportCard implements Comparable<ReportCard>{
        int p;
        int c;
        int m;
        
        ReportCard(int p , int c , int m){
            this.p = p;
            this.c = c;
            this.m = m;
        }
        
        public int compareTo(ReportCard o){
            if(this.p != o.p){
                return this.p - o.p; // physics marks in ascending order
            }
            else if(this.c != o.c){
                return - (this.c - o.c); // chemistry marks will be in descending order
            }
            else{
                return this.m - o.m; // maths marks in ascending order
            }
        }
    }

    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[]phy,int[]chem,int[]math , int N) {
        //write your code here
        ReportCard[] arr = new ReportCard[N];
        
        for(int i = 0 ; i < N; i++){
            ReportCard obj = new ReportCard(phy[i] , chem[i] , math[i]);
            arr[i] = obj;
        }
        Arrays.sort(arr);
        
        for(int i = 0 ; i < N ; i++){
            ReportCard obj = arr[i];
            phy[i] = obj.p;
            chem[i] = obj.c;
            math[i] = obj.m;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math , N);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}