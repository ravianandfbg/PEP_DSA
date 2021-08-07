import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String argsp []){
        HashMap<String,Integer> hm = new HashMap<>();

        System.out.println(hm);

        //put() operation
        hm.put("India" , 200);
        hm.put("USA" , 250);
        hm.put("China" , 140);
        hm.put("UK" , 190);
        hm.put("Dubai" , 210);

        System.out.println(hm);
        
        // get() operation
        System.out.println("India : "+ hm.get("India"));
        System.out.println("india : "+ hm.get("india"));

        //insert
        hm.put("France" , 175);
        System.out.println(hm);

        // update
        hm.put("India" , 199);
        System.out.println(hm);

        //remove() operation
        Integer tmp = hm.remove("India");
        System.out.println(hm);
        System.out.println(tmp);

        tmp = hm.remove("Utopia");
        System.out.println(tmp);

        //containsKey() operation
        System.out.println(hm.containsKey("USA"));
        System.out.println(hm.containsKey("Utopia"));

        //keySet() operation
        // System.out.println(hm.keySet());

        // // convert Set -> ArrayList
        // ArrayList<String> list = new ArrayList<>(hm.keySet());
        // System.out.println(list);

        for(String key : hm.keySet()){
            System.out.println(key + " --> "+hm.get(key));
        }
    }
}
