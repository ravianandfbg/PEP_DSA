// Time : O(N)          space : O(N)

public class Main{
      
public static int[] solve(int[] arr){
      // solve
      int n = arr.length;
      int[] nge = new int[n]; // nge : next greater element
   
      Stack<Integer> st = new Stack<>();
      nge[n - 1] = -1;
      st.push(arr[n - 1]);
   
      for(int i = n - 2 ; i >= 0 ; i--){
   
        while(st.size() > 0 && st.peek() <= arr[i]){
          st.pop();
        }
   
        if(st.size() == 0){
          nge[i] = -1;
        }
        else{
          nge[i] = st.peek();
        }
   
        st.push(arr[i]);
      }
      return nge;
    }
}