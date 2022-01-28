package DAY09.P7579;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cost;
    static long[] memory;
    static long[][] dp;
    static int n,m;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY09/P7579/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cost = new int[n + 1];
        memory = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        int TotalCost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            TotalCost += cost[i];
        }

        dp = new long[n+1][TotalCost + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < TotalCost + 1; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(j - cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - cost[i]] + memory[i]);
                }
            }
        }
        int ans;
        for (int i = 1; i < TotalCost + 1 ; i++) {
            if (dp[n][i] >= m) {
                System.out.println(i);
                return;
            }
        }

    }
}
