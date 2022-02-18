package DAY01.P1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            System.out.println(find(a));
        }
    }

    static int find(int a) {
        int low = 0;
        int high = arr.length - 1;
//        int mid = (low + high) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == a) {
                return 1;
            } else if (arr[mid] > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
