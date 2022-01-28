package DAY09.P11049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Matrix {
    int row, col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Main {
    static int n;
    static int[][] dp;
    static ArrayList<Matrix> arr;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws  Exception {
        System.setIn(new FileInputStream("src/DAY09/P11049/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Matrix(a, b));
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                dp[i][j] = INF;
            }
        }


    }
}
