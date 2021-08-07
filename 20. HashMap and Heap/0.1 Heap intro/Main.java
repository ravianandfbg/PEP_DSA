import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static class Person implements Comparable<Person>{
        int wt,marks,rank;

        Person(int wt,int marks,int rank){
            this.wt = wt;
            this.marks = marks;
            this.rank = rank;
        }

        public String toString(){
            return "WT : "+this.wt+"\t Marks : "+this.marks+"\t Rank : "+this.rank;
        }
        
        // compareTo : +ve , -ve , 0
        // min : this - o
        // max : o - this
        public int compareTo(Person o){ // o : Other
            return o.rank-this.rank;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<Person> pq = new PriorityQueue<>();
        
        pq.add(new Person(10,-95,3));
        pq.add(new Person(5,99,1));
        pq.add(new Person(15,0,25));
        pq.add(new Person(6,-32,12));
        pq.add(new Person(3,51,10));
        pq.add(new Person(20,-40,11));

        // System.out.println(pq.peek());
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // // System.out.println(pq);
        // pq.add(10);
        // // System.out.println(pq);
        // pq.add(-1);
        // // System.out.println(pq);
        // pq.add(5);
        // // System.out.println(pq);
        // pq.add(8);
        // // System.out.println(pq);
        // pq.add(13);
        // // System.out.println(pq);
        // pq.add(0);
        // // System.out.println(pq);
        // pq.add(10);
        // System.out.println(pq);

        // // peek : highest priority element 
        // System.out.println(pq.peek());

        // System.out.println("Size "  + pq.size());

        // while(pq.size() > 0){
        //     System.out.println(pq.remove());
        // }
    }
}
