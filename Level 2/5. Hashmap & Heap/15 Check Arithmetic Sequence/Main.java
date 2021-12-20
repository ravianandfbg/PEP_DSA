import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        // write your code here
        
        int min = Integer.MAX_VALUE;
        int second_Min = Integer.MAX_VALUE;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < min){
                second_Min = min;
                    min = arr[i];
            }
            else if(arr[i] < second_Min){
                second_Min = arr[i];
            }
            hs.add(arr[i]);
        }
        int cd = second_Min - min; // cd : common difference
        
        if(cd == 0 && hs.size() > 1){
            return false;
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            int term = i * cd + min;
            
            if(hs.contains(term) == false){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
