package Day10.P5582;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static String a,b;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/DAY10/P5582/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
//        System.out.println(a + b);
        dp = new int[a.length() + 1][b.length() + 1];
        int ans = 0;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        System.out.println(ans);

    }
}
