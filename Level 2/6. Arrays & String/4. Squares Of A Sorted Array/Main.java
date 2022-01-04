import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int[] ans = new int[nums.length];
        int i = 0; // pointer 1
        int j = nums.length - 1; // pointer 2
        int k = nums.length - 1;
        
        while(i <= j){
            if (nums[i] * nums[i] <= nums[j] * nums[j]){
                ans[k] = nums[j] * nums[j];
                j--;
            }
            else{
                ans[k] = nums[i] * nums[i];
                i++;
            }
            k--;
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}