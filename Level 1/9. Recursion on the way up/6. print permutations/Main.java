import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        printPermutations(str,"");

    }

    public static void printPermutations(String qsf, String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        
        for(int i = 0; i < qsf.length(); i++){
        char ch = qsf.charAt(i);
        String lpart = qsf.substring(0,i); //lpart : left part
        String rpart = qsf.substring(i+1); //rpart : right part
        printPermutations(lpart + rpart,asf+ch);
        }
    }

}