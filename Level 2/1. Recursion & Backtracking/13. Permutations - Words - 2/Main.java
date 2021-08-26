import java.io.*;
import java.util.*;

public class Main {

    //cc : current character
  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    // write your code here
    if(cc == str.length()){
        for(char ch : spots){
        System.out.print(ch);
        }
        System.out.println();
        return;
    }
    
    char ch = str.charAt(cc);
    int last_occurence = lastOccurence.get(ch);
    
    for(int i = last_occurence + 1 ; i < spots.length ; i++){
        if(spots[i] == null){ // if not occupy
            spots[i] = ch;
            lastOccurence.put(ch , i); // update lastOccurence
            generateWords(cc + 1 , str , spots , lastOccurence);
            lastOccurence.put(ch , last_occurence);
            spots[i] = null;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}