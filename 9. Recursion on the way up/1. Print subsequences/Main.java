import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        printSS(str,"");

    }
   //qsf : question so far
   //asf : answer so far
    public static void printSS(String qsf, String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = qsf.charAt(0);
        String roq = qsf.substring(1); //roq : rest of question
        
        printSS(roq,asf+ch);
        printSS(roq,asf);
        
    }

}