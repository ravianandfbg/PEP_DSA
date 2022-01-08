import java.util.*;

public class Main {
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static boolean IsVowel(char ch){
        String vowels = "aeiouAEIOU";
        int idx = vowels.indexOf(ch);
        
        if(idx == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        char[] arr = s.toCharArray();
        
        while(i < j){
            while(i < j && IsVowel(arr[i]) == false){
                i++;
            }
            while(i < j && IsVowel(arr[j]) == false){
                j--;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
}
  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}
