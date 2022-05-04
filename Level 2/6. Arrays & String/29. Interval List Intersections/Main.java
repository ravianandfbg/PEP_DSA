class Solution {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
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
              // valid path
              list.add(new int[]{sp , ep});
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
}