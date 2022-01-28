package DAY02.P1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int sum = 0, len = 1, ans = 987654321, lpos = 0, hpos = 0;
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = arr[lpos];

        while (lpos <= N - 1 && hpos <= N-1) {
            //sum >= S lpos++ len-- sum -=
            if (sum >= S) {
                sum -= arr[lpos++];
                ans = Math.min(ans, len);
                len--;
            } else {
                sum += arr[++hpos];
                len++;
            }
        }
        if (ans == 987654321) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
