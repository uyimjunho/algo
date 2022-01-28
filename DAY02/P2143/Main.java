package DAY02.P2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
//        System.out.println(T);

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
//        System.out.println(n);

        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr1));

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
//        System.out.println(m);
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr2));
        ArrayList<Integer> subA = new ArrayList<Integer>();
        ArrayList<Integer> subB = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            subA.add(arr1[i]);
            int tmp = arr1[i];
            for (int j = i + 1; j < n; j++) {
                tmp += arr1[j];
                subA.add(tmp);
            }
        }
        for (int i = 0; i < m; i++) {
            subB.add(arr2[i]);
            int tmp = arr2[i];
            for (int j = i + 1; j < m; j++) {
                tmp += arr2[j];
                subB.add(tmp);
            }
        }
        Collections.sort(subA);
        Collections.sort(subB);

//        System.out.println(subA);
        int apos = 0, bpos = subB.size() - 1;
        long ans = 0;
        while (apos < subA.size()  && bpos >= 0) {
            int a = subA.get(apos);
            int acount = 0;
            int b = subB.get(bpos);
            int bcount = 0;

            if (a + b == T) {
                while (apos < subA.size() && subA.get(apos) == a) {
                    apos++;
                    acount++;
                }
                while (bpos >= 0 && subB.get(bpos) == b) {
                    bpos--;
                    bcount++;
                }
                ans += (long)acount * (long)bcount;
            } else if (a + b < T) {
                apos++;
            } else {
                bpos--;
            }
        }
        System.out.println(ans);
    }
}
