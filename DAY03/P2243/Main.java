package DAY03.P2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.StringTokenizer;

public class Main {
    static int n, A, B, C, s;
    static int[] tree;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P2243/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        initBU();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if (A == 2) {
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                updateTD(1, s, 1, B, C);
            } else {
                B = Integer.parseInt(st.nextToken());
                int ans = queryTD(1, s, 1, B);
                System.out.println(ans);
                updateTD(1,s,1, ans, -1);
            }



        }
    }

    static void initBU() {
        s = 1;
        while (s < 1000000) {
            s *= 2;
        }
        tree = new int[2 * s];
    }

    static void updateTD(int left, int right, int node, int target, int diff) {
        int mid = (left + right) / 2;
        if (left <= target && target <= right) {
            tree[node] += diff;
            if (left != right) {
                updateTD(left, mid, node * 2, target, diff);
                updateTD(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    static int queryTD(int left, int right, int node, int queryCount) {
        //1.
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (tree[node * 2] >= queryCount) {
            return queryTD(left, mid, node * 2, queryCount);
        } else {
            return queryTD(mid + 1, right, node * 2 + 1, queryCount - tree[node * 2]);

        }
       // return 0;
    }
}
