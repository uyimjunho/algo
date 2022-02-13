package Day10.P14003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static List<Integer> Dp;
    static int[] indexOrder;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Day10/P14003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
         }
        Dp = new ArrayList<>();
        indexOrder = new int[n + 1];
        Dp.add(arr[1]);
        indexOrder[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int searchIndex = bSearch(arr[i]) + 1;
            indexOrder[i] = searchIndex;
            if (searchIndex > Dp.size()) {
                Dp.add(arr[i]);
            } else {
                Dp.set(searchIndex-1, arr[i]);
            }
        }
        int l = Dp.size();
        int[] ans = new int[l+1];
        System.out.println(l);
        for (int i = n; i > 0; i--) {
            if (l == indexOrder[i]) {
//                System.out.print(arr[i] + " ");
                ans[l] = arr[i];
                l--;
            }
        }
        for (int i = 1; i <= Dp.size(); i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static int bSearch(int n) {
        int low = 0;
        int high = Dp.size() - 1;
        int mid = low + high / 2;

        while (low <= high) {
            mid = (low + high) / 2;
            if (Dp.get(mid) == n) {
                return mid;
            } else if (Dp.get(mid) > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
