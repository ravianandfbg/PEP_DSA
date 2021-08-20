import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    solve(exp);
 }
 
 public static void solve(String exp){
     Stack<Integer> eval = new Stack<>();
     Stack<String> preExp = new Stack<>();
     Stack<String> inExp = new Stack<>();
     
     for(int idx = 0; idx < exp.length(); idx++){
         char ch = exp.charAt(idx);
         
         if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
             evaluation(eval,ch);
             prefixExpBuild(preExp, ch);
             infixExpBuild(inExp, ch);
         }
         else{
             eval.push(Integer.parseInt(ch+""));
             inExp.push(ch+"");
             preExp.push(ch+"");
         }
     }
     System.out.println(eval.pop());
     System.out.println(inExp.pop());
     System.out.println(preExp.pop());
    }
    
    public static void evaluation(Stack<Integer> eval, char op){
        int v2 = eval.pop(), v1 = eval.pop();
        
        if(op == '+'){
            eval.push(v1+v2);
        }
        else if(op == '-'){
            eval.push(v1-v2);
        }
        else if(op == '*'){
            eval.push(v1*v2);
        }
        else if(op == '/'){
            eval.push(v1/v2);
        }
    }
    
    public static void prefixExpBuild(Stack<String> preExp, char op){
        String v2 = preExp.pop() , v1 = preExp.pop();
        preExp.push(op+v1+v2);
    }
    
    public static void infixExpBuild(Stack<String> inExp, char op){
        String v2 = inExp.pop() , v1 = inExp.pop();
        inExp.push("("+v1+op+v2+")");
    }
}