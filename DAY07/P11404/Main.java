package DAY07.P11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 987654321;
                }

            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s, e, w;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map[s][e] = Math.min(map[s][e], w);
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (map[i][j] == 987654321) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
