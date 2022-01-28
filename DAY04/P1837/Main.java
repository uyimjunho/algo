package DAY04.P1837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isNotPrime;
    static String P;
    static int K;
    static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        isNotPrime = new boolean[K + 1];

        for (int i = 2; i < K + 1; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j < K + 1; j++) {
                    isNotPrime[i] = true;
                }
            }
        }
        for (int prime : primes) {
            if (prime >= K) {
                break;
            }
            if (checkIsBad(prime)) {
                System.out.println("BAD");
                return;
            }
        }
        System.out.println("GOOD");
    }

    static boolean checkIsBad(int x) {
        int r = 0;
        for (int i = 0; i < P.length(); i++) {
            r = (r * 10 + (P.charAt(i) - '0')) % x;
        }
        if (r == 0) {
            return true;
        }
        return false;
    }
}
