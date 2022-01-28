package DAY09.P2098;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int W[][];
    static int dp[][];
    static int VisitAll;
    static int ans;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY09/P2098/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        W = new int[n+1][n+1];
        VisitAll = (1 << n) - 1;
        dp = new int[n+1][VisitAll + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 987654321;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= VisitAll; j++) {
                dp[i][j] = 987654321;
            }
        }

        dp[1][1] = 0;
        getdp(1, 1);
        System.out.println(ans);
    }

    public static void getdp(int now, int visited) {
        if (visited == VisitAll) {
            if (W[now][1] == 0) {
                return;
            }
            ans = Math.min(ans, dp[now][visited] + W[now][1]);
        }

        for (int i = 1; i <= n; i++) {
            int next = (1 << (i - 1));
            int nextVisited = visited | next;
            if (nextVisited == visited) {
                continue;
            }
            if (W[now][i] == 0) {
                continue;
            }

            if (dp[i][nextVisited] > dp[now][visited] + W[now][i]) {
                dp[i][nextVisited] = dp[now][visited] + W[now][i];
                getdp(i, nextVisited);
            }
        }
    }
}
