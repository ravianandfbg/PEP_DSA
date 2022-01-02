import java.util.*;
 
 import javax.sound.sampled.BooleanControl.Type;
 
 public class Main {
 	 public static void main(String[] args) {
 
 	 	 Scanner scn = new Scanner(System.in);
 	 	 String name = scn.next();
 	 	 String typed = scn.next();
 	 	 System.out.println(isLongPressedName(name, typed));
 
 	 }
 
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 strings
 	 // It should return boolean output.
 	 public static boolean isLongPressedName(String name, String typed) {
 	 	 // Write your code here
 	 	  if(typed.length() < name.length()){
            return false;
        }
        
        int i = 0; // pointer 1
        int j = 0; // pointer 2
        
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                j++;
            }
            else{
                return false;
            }
        }
        return i == name.length();
 	 }
 
 }