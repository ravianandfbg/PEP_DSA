import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int p1 = st.pop() , p2 = st.pop();
            
            if(arr[p1][p2] == 1){
                //p2 can be a celebrity
                st.push(p2);
            }
            else{
                //p1 can be a celebrity
                st.push(p1);
            }
        }
        
        int possibleCelebrity = st.pop();
        
        for(int col = 0; col < n; col++){
            if(arr[possibleCelebrity][col] == 1){
                System.out.println("none");
                return;
            }
        }
        
        for(int row = 0; row < n; row++){
            if(arr[row][possibleCelebrity] == 0 && row != possibleCelebrity){
                System.out.println("none");
                return;
            }
        }
        System.out.println(possibleCelebrity);
    }

}