import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    HashMap<String , String> map = new HashMap<>(); // employee vs manager
    String ceo = "";
    
    while(n-- > 0){
        String emp = scn.next();
        String manager = scn.next();
        
        map.put(emp , manager);
    }
    
    // manager vs (direct employees under manager)
    HashMap<String,ArrayList<String>> gt = new HashMap<>(); // gt : generic tree 
    
    for(String emp : map.keySet()){
        String manager = map.get(emp);
        
        if(emp.equals(manager) == true){
            ceo = emp;
            ArrayList<String> list = gt.getOrDefault(manager , new ArrayList<>());
            gt.put(emp , list);
            continue;
        }
        if(gt.containsKey(emp) == false){
            gt.put(emp , new ArrayList<>());
        }
        
        ArrayList<String> list = gt.getOrDefault(manager , new ArrayList<>());
        list.add(emp);
        gt.put(manager , list);
    }
    
    HashMap<String,Integer> res = new HashMap<>();
    getSize(ceo , gt , res);
    
    for(String key : res.keySet()){
        System.out.println(key +" " + res.get(key));
    }
  }
  
  public static int getSize(String root , HashMap<String,ArrayList<String>> gt , HashMap<String , Integer> res){
      
      int size = 0;
      
      for(String child : gt.get(root)){
          int cfs = getSize(child , gt , res); // cfs : child family size
          size += cfs;
      }
      res.put(root , size);
      return size + 1;
  }

}