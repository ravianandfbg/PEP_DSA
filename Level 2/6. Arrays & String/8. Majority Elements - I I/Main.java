import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] nums) {
        // write your code here
        
        int val1 = nums[0];
        int count1 = 1;
        
        int val2 = 0;
        int count2 = 0;
        
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == val1){
                count1++;
            }
            else if(nums[i] == val2){
                count2++;
            }
            
            else{
            if(count1 == 0){
                val1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                val2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
          }
        }
        
        int freq1 = 0 , freq2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == val1){
                freq1++;
            }
            else if(nums[i] == val2){
                freq2++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(freq1 > nums.length / 3){
            ans.add(val1);
        }
        if(freq2 > nums.length / 3){
            ans.add(val2);
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}