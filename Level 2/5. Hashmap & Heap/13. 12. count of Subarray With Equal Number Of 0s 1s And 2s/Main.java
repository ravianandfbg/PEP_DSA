import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        
        HashMap<String , Integer> map = new HashMap<>(); // [(c0 - c1) @ (c2 - c1)] vs index
        
        int c0 = 0; // c0 : count of 0
        int c1 = 0; // c1 : count of 1
        int c2 = 0; // c2 : count of 2
        int count = 0; 
        
        map.put("0 @ 0" , 1); // keys , frequency // @ symbole is not necessary
        
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                c0++;
            }
            else if(arr[i] == 1){
                c1++;
            }
            else{
                c2++;
            }
            
            String key = (c1 - c0) + " @ " + (c2 - c1); // if we write @ in line 14 then, we will write @ here
            
            if(map.containsKey(key) == false){
                // see key 1st time
                map.put(key , 1);
            }
            else{
                int oFreq = map.get(key); // oFreq : old frequency
                count += oFreq;
                map.put(key , oFreq + 1);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
