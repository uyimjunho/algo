package DAY02.P2096;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/DAY02/P2096/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][5];

        System.out.println(getHigh() + " " + getLow());

    }
    static int getHigh() {

        for (int i = 0; i < n; i++) {
            arr[i][0] = 0;
            arr[i][4] = 0;
        }

        for (int i = 1; i <= 3; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1])) + arr[i][j];
                //dp[i][j] = dp[i - 1][j] + Math.max(arr[i][j-1], Math.max(arr[i][j] , arr[i][j+1]));
            }
        }
        int max = 0;
        for (int i = 1; i < 4; i++) {
            if (max < dp[n - 1][i]) {
                max = dp[n - 1][i];
            }
        }
        return max;
    }
    static int getLow() {
        for (int i = 0; i < n; i++) {
            arr[i][0] = INF;
            arr[i][4] = INF;
            dp[i][0] = INF;
            dp[i][4] = INF;
        }

        for (int i = 1; i <= 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + arr[i][j];
                //dp[i][j] = dp[i - 1][j] + Math.min(arr[i][j-1], Math.min(arr[i][j] , arr[i][j+1]));
            }
        }
        int min = INF;
        for (int i = 1; i < 4; i++) {
            if (min > dp[n - 1][i]) {
                min = dp[n - 1][i];
            }
        }
       // System.out.println(Arrays.toString(dp[n-2]));
        return min;
    }
}
