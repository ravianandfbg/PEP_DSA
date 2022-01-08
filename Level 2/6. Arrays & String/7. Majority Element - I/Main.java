import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] nums) {
        // write your code here
        int val = nums[0];
        int count = 1;
        
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == val){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                val = nums[i];
                count = 1;
            }
        }
        
        // val contains potential majority element
        int freq = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == val){
                freq++;
            }
        }
        if(freq > nums.length / 2){
            System.out.println(val);
        }
        else{
            System.out.println("No Majority Element exist");
            
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}