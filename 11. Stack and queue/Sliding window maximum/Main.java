import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int nger[] = new int[n];
    nger[n-1] = n;
    
    Stack <Integer> st = new Stack <> ();
    st.push(n-1);
    
    for(int i = n-2 ; i >= 0 ; i--){
        while(st.size() > 0 && arr[i] > arr[st.peek()]){
            st.pop();
        }
        if(st.size() == 0){
            nger[i] = n;
        }
        else{
            nger[i] = st.peek();
        }
        st.push(i);
    }
    int j = 0;
    for(int i = 0 ; i < n-k+1 ; i++){
        if(j < i ){
            j = i;
        }
        while(nger[j] < i+k){
            j = nger[j];
        }
        System.out.println(arr[j]);
    }
    
 }
}