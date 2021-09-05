// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    if (i == 9) {
      display(board);
      return;
    }
    int nr; // new row
    int nc; // new column
    if (j == board.length - 1) {
      nr = i + 1;
      nc = 0;
    } else {
      nr = i;
      nc = j + 1;
    }

    if (board[i][j] == 0) {
      for (int n = 1 ; n <= 9 ; n++) {
        if (isValid(board, i, j, n) == true) {
          board[i][j] = n;
          solveSudoku(board, nr, nc);
          board[i][j] = 0;
        }
      }
    } else {
      solveSudoku(board, nr, nc);
    }
  }

  public static boolean isValid(int board[][], int i, int j, int digit) {
    // row
    for (int r = i, c = 0 ; c < 9 ; c++) {
      if (board[r][c] == digit) {
        return false;
      }
    }

    // col
    for (int r = 0, c = j ; r < 9 ; r++) {
      if (board[r][c] == digit) {
        return false;
      }
    }

    // block
    int sr = (i / 3) * 3; // sr : starting row
    int sc = (j / 3) * 3; // sc : starting column

    for (int m = 0 ; m < 3 ; m++) {
      for (int n = 0 ; n < 3 ; n++) {
        if (board[sr + m][sc + n] == digit) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
