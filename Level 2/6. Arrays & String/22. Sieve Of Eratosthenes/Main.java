// Sieve of Eratosthenes algorithm
 
// time : O(N*(log(log(N)))  , space : O(N)

class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true); // initially mark all numbers true
        
        for(int k = 2 ; k * k <= n ; k++){
            if(arr[k] == true){
                for(int i = 2*k ; i <= n ; i += k){
                    arr[i] = false;
                }
            }
        }
        for(int i = 2 ; i < n ; i++){
            if(arr[i] == true){
                count++;
            }
        }
        return count;
    }
}