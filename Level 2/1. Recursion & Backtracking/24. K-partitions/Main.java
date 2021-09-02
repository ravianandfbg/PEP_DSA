import java.io.*;
import java.util.*;

public class Main {

	static int count;
	public static void solution(int i, int n, int k, int csne, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		// csne : count of non empty string
		if(i > n){
		    if(csne == k){
		        count++;
		        System.out.print(count+". ");
		        for(ArrayList<Integer> set : ans){
		            System.out.print(set+" ");
		        }
		        System.out.println();
		    }
		    return;
		}
		for(ArrayList<Integer> set : ans){
		    if(set.size() > 0){
		        set.add(i);
		        solution(i + 1 , n , k , csne , ans);
		        set.remove(set.size() - 1);
		    }
		    else{
		        set.add(i);
		        solution(i + 1 , n , k , csne + 1 , ans);
		        set.remove(set.size() - 1);
		        break;
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		count = 0;
		solution(1, n, k, 0, ans);

	}

}