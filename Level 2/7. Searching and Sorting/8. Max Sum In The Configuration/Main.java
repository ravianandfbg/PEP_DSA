import java.util.*;

public class Main {

    public static int maximise(int[]arr , int n) {
        //write your code here
        n = arr.length;
    int sum = 0;
	int si = 0; // initially i = 0, si = s0
	
	for(int i = 0 ; i < n ; i++){
	    sum += arr[i];
	    si += arr[i] * i;
	}
	int max = si;
	
	for(int i = 0 ; i < n - 1 ; i++){
	    int Sip1 = si + sum - n * arr[n - 1 - i]; // Sip1 : si plus 1
	    
	    if(Sip1 > max){
	        max = Sip1;
	    }
	    si = Sip1;
	}
	return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr , n);
        System.out.println(ans);
    }
}