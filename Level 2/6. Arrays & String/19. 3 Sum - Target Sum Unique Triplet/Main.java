// time : O(n^2) , space : O(1)

import java.util.*;

public class Main {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  
  // tsUniquePairs : target sum unique pairs(two sum ka code)
  public static List<List<Integer>> tsUniquePairs(int[] nums , int si , int target){
      int i = si; // si : starting index
      int j = nums.length - 1;
      
      List<List<Integer>> ans = new ArrayList<>();
      
      while(i < j){
          if(i != si && nums[i] == nums[i - 1]){
              i++;
              continue;
          }
          
          if(nums[i] + nums[j] == target){
              ArrayList<Integer> res = new ArrayList<>();
              res.add(nums[i]);
              res.add(nums[j]);
              ans.add(res);
              
              i++;
              j--;
          }
          else if(nums[i] + nums[j] < target){
              i++;
          }
          else{
              j--;
          }
      }
          return ans;
  }
  public static List<List<Integer>> threeSum(int[] nums, int target) {
    // write your code here
    Arrays.sort(nums);
    
    List<List<Integer>> ans = new ArrayList<>();
    
    for(int i = 0 ; i < nums.length - 2 ; i++){
        if(i != 0 && nums[i] == nums[i - 1]){
            continue;
        }
        List<List<Integer>> res = tsUniquePairs(nums , i+1 , target - nums[i]);
        
        for(List<Integer> list : res){
            list.add(nums[i]);
            ans.add(list);
        }
    }
        return ans;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = threeSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}