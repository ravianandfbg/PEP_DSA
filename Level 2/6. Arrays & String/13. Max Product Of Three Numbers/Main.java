// time:O(N)
// space:O(1)

class Solution {
    public int maximumProduct(int[] nums) {
        // intialize 1st maximuum , 2nd maximum , 3rd maximum numbers
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        // intialize 1st minimum and 2nd minimum numbers
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++){
            // update 1st maximum , 2nd maximum and 3rd maximum numbers
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            
            // update 2nd maximum and 3rd maximum numbers
            else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            //update 3rd maximum numbera
            else if(nums[i] > max3){
                max3 = nums[i];
            }
            
            // update 1st minimum and 2nd minimum numbers
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }
            // update 2nd minimum number
            else if(nums[i] < min2){
                min2 = nums[i];
            }
        }
        int product1 = max1 * max2 * max3;
        int product2 = min1 * min2 * max1;
        
        int maxProduct = Math.max(product1 , product2);
        return maxProduct;
    }
}