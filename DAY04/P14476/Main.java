package DAY04.P14476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] larr;
    static int[] rarr;
    static int N;

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        larr = new int[N];
        rarr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));
        larr[0] = arr[0];
        rarr[N - 1] = arr[N - 1];
        for (int i = 1; i < N; i++) {
            larr[i] = gcd(larr[i-1], arr[i]);
            rarr[N - i - 1] = gcd(rarr[N - i], arr[N - i - 1]);
        }
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            if (i == 0) {
                gcd = rarr[1];
            } else if (i == N - 1) {
                gcd = larr[N - 2];
            } else {
                gcd = gcd(larr[i - 1] , rarr[i + 1]);
            }

            if (arr[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIdx = i;
            }
        }
        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max + " " + arr[maxIdx]);
        }
    }
}
