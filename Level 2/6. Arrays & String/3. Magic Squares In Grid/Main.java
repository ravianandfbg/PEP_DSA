import java.util.*;
  
  public class Main {
  	  public static void main(String[] args) {
  	  	  Scanner scn = new Scanner(System.in);
  	  	  int r = scn.nextInt();
  	  	  int c = scn.nextInt();
  	  	  int[][] Input = new int[r][c];
  	  	  for (int i = 0; i < r; i++) {
  	  	  	  for (int j = 0; j < c; j++) {
  	  	  	  	  Input[i][j] = scn.nextInt();
  	  	  	  }
  	  	  }
  	  	  System.out.print(numMagicSquaresInside(Input));
  	  }
  
  	  // -----------------------------------------------------
  	  // This is a functional problem. Do not make changes to main
  	  // This function takes as input an array and integer k.
  	  // It should print required output.
  	  public static int numMagicSquaresInside(int[][] grid) {
  	  	  // Write your code here
  	  	  
  	  	  int n = grid.length , m = grid[0].length , res = 0;
        
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = 0 ; j < m - 2 ; j++){
                if(isMagic(grid , i , j)){
                    res++;
                }
            }
        }
        return res;
    }
    
    public static boolean isMagic(int[][] grid , int row , int col){
        int[] record = new int[50];
        
        for(int i = row ; i < row + 3 ; i++){
            for(int j = col ; j < col + 3 ; j++){
                if(grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0){
                    return false;
                }
                record[grid[i][j]] = 1;
            }
        }
        int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (sum1 != sum2) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
                return false;
            }
        }
        return true;
  	  }
  }