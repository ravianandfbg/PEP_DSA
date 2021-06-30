import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String exp = scn.nextLine();
    
    System.out.println(evaluate(exp));
 }
 
 public static int evaluate(String exp){
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    for(int idx = 0 ; idx < exp.length() ; idx++){
        char ch = exp.charAt(idx);
        
        if(ch == '('){
            operators.push(ch);
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operators.size() > 0 && operators.peek() != '(' && precedence(operators.peek()) >= precedence(ch)){
                char op = operators.pop();
                int v2 = operands.pop() , v1 = operands.pop();
                
                if(op == '+') operands.push(v1 + v2);
                else if(op == '-') operands.push(v1-v2);
                else if(op == '/') operands.push(v1/v2);
                else if(op == '*') operands.push(v1*v2);
            }
            
            operators.push(ch);
            
        }else if(ch == ')'){
            while(operators.peek() != '('){
                char op = operators.pop();
                int v2 = operands.pop() , v1 = operands.pop();
                
                if(op == '+') operands.push(v1 + v2);
                else if(op == '-') operands.push(v1-v2);
                else if(op == '/') operands.push(v1/v2);
                else if(op == '*') operands.push(v1*v2);
            }
            
            operators.pop(); // opening bracket
            
        }else if(ch >= '0' && ch <='9'){
            operands.push(Integer.parseInt(ch+""));
        }
    }
    
    while(operators.size() > 0){
        char op = operators.pop();
        int v2 = operands.pop() , v1 = operands.pop();
        
        if(op == '+') operands.push(v1 + v2);
        else if(op == '-') operands.push(v1-v2);
        else if(op == '/') operands.push(v1/v2);
        else if(op == '*') operands.push(v1*v2);
    }
    
    return operands.pop();
 }
 
 public static int precedence(char op){
    if(op == '+' || op == '-'){
        return 2;
    }else {
        // if(op == '*' || op == '/')
        return 4;
    }
 }
}