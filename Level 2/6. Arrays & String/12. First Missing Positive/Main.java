import java.util.*;

public class Main {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] nums) {
    // write your code here
     int pe = segregate(nums);
        
        for(int i = 0 ; i <= pe ; i++){
            int idx = Math.abs(nums[i]) - 1;
            
            if(idx <= pe && nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }
        for(int i = 0 ; i <= pe ; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return pe + 2;
    }
    
    public static int segregate(int[] nums){
        int i = 0;
        int j = 0;
        
        // 0 to i-1 -> 0
        // i to j-1 -> <= 0
        // j to n-1 -> unknown
        
        while(j < nums.length){
            if(nums[j] <= 0){
                j++;
            }
            else{
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j++;
            }
        }
        return i - 1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}