import java.util.*;
public class thirteen {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //write your code here

        int n = scn.nextInt();

        for (int row = 0; row < n; row++) {
            int val = 1; //permutation and combination
            for (int col = 0; col <= row; col++) {
                System.out.print(val + "	");
                val = (val * (row - col)) / (col + 1);
            }
            System.out.println();
        }

    }
}