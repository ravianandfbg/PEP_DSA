import java.io.*;
import java.util.*;

public class Main {
    
    public static class Item implements Comparable<Item>{
        int vl,wt;
        Double vwr; // vwr : value weight ratio
       
        // this - o : ins
        // o - this : dec
        public int compareTo(Item o){
            if(o.vwr < this.vwr){
                return -1;
            }else if(o.vwr == this.vwr){
                return 0;
            }else{
                return 1;
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
       
        int n = scn.nextInt();
       
        int vls[] = new int[n]; // vls : values
        for(int i = 0 ; i < n ; i++)
            vls[i] = scn.nextInt();
           
        int wts[] = new int[n]; //wts : weights
        for(int i = 0 ; i < n ; i++)
            wts[i] = scn.nextInt();
           
        int cap = scn.nextInt(); //cap : capacity
       
        // logic
       
        Item items[] = new Item[n];
       
        for(int i = 0 ; i < n ; i++){
            items[i] = new Item();
            items[i].vl = vls[i];
            items[i].wt = wts[i];
            items[i].vwr = (vls[i]*1.0) / wts[i];
        }
       
        Arrays.sort(items);
        
        int idx = 0;
        double tval = 0; //tval : total value
        while(idx < n && cap != 0){
            if(items[idx].wt <= cap){
                cap = cap - items[idx].wt;
                tval = tval + items[idx].vl;
                idx++;
            }
            else{
                tval = tval + cap * items[idx].vwr;
                cap = 0;
            }
            
        }
        System.out.println(tval);
       
       
    }
}