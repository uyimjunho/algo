package DAY02.P2003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lpos = 0, hpos = 0, ans = 0;
        int[] arr = new int[a+1];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = arr[lpos];
//        System.out.println(Arrays.toString(arr));
        while (lpos <= a-1 && hpos <= a-1) {
            if (sum == b) {
                ans++;
                sum -= arr[lpos++];
            } else if (sum < b) {
                sum += arr[++hpos];
            } else {
                sum -= arr[lpos++];
            }
        }
        System.out.println(ans);
    }
}
