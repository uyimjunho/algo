package Day10.P7578;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY10/P7578/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr1 = new int[N + 1];
        arr2 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }


    }
}
