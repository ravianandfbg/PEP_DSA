import java.util.*;

public class Main {
  public static int[][] intersection(int firstList[][], int secondList[][]) {
    // write your code here
        int i = 0;
        int j = 0;
        
        ArrayList<int[]> list = new ArrayList<>();
        
        while(i < firstList.length && j < secondList.length){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
        
            int sp = Math.max(s1 , s2); // sp : starting point
            int ep = Math.min(e1 , e2); // ep : ending point
            
            if(sp <= ep){
                list.add(new int[]{sp,ep});
            }
            if(e1 < e2){
                i++;
            }
            else{
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        res = list.toArray(res);
        
        return res;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Input format
    int n = scn.nextInt();
    int list1[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      list1[i][0] = scn.nextInt();
      list1[i][1] = scn.nextInt();
    }

    int m = scn.nextInt();
    int list2[][] = new int[m][2];
    for (int i = 0 ; i < m ; i++) {
      list2[i][0] = scn.nextInt();
      list2[i][1] = scn.nextInt();
    }

    // output
    int ans[][] = intersection(list1, list2);
    System.out.print("[");
    for (int interval[] : ans) {
      System.out.print(Arrays.toString(interval));
    }
    System.out.println("]");
  }
}
