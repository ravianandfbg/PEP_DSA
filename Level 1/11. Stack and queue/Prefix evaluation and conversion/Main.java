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
     Stack<String> postExp = new Stack<>();
     Stack<String> inExp = new Stack<>();
     
     for(int idx = exp.length()-1; idx >= 0; idx--){
         char ch = exp.charAt(idx);
         
         if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
             evaluation(eval,ch);
             postfixExpBuild(postExp, ch);
             infixExpBuild(inExp, ch);
         }
         else{
             eval.push(Integer.parseInt(ch+""));
             inExp.push(ch+"");
             postExp.push(ch+"");
         }
     }
     System.out.println(eval.pop());
     System.out.println(inExp.pop());
     System.out.println(postExp.pop());
    }
    
    public static void evaluation(Stack<Integer> eval, char op){
        int v1 = eval.pop(), v2 = eval.pop();
        
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
    
    public static void postfixExpBuild(Stack<String> postExp, char op){
        String v1 = postExp.pop() , v2 = postExp.pop();
        postExp.push(v1+v2+op);
    }
    
    public static void infixExpBuild(Stack<String> inExp, char op){
        String v1 = inExp.pop() , v2 = inExp.pop();
        inExp.push("("+v1+op+v2+")");
    }
}