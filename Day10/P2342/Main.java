package Day10.P2342;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] dp;
    static List<Integer> num;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day10/P2342/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a;
        num = new ArrayList<>();

        while (true) {
            a = Integer.parseInt((st.nextToken()));
            if (a == 0) {
                break;
            }
            num.add(a);
        }
//        System.out.println(num);
        dp = new int[num.size() + 1][5][5];


    }
}
