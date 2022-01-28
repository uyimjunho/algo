package DAY02.P2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

        }

//        System.out.println(Arrays.toString(tree));
        Arrays.sort(tree);
//        System.out.println(Arrays.toString(tree));
        long start = 0, end = tree[N-1],  cut;
        long ans = 0;
        while (start <= end) {
            cut = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] - cut > 0) {
                    sum += tree[i] - cut;
                }
            }
            if (sum == M) {
                ans = cut;
                //System.out.println(ans);
                break;
            } else if (sum > M) {
                start = cut + 1;
                ans = cut;
            } else {
                end = cut - 1;

            }
        }
        System.out.println(ans);
    }
}
