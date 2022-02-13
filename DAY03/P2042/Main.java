package DAY03.P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, s;
    static long[] leaf;
    static long[] indexTree;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        leaf = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            leaf[i] = Long.parseLong(br.readLine());
        }
        s = 1;
        while (n > s) {
            s *= 2;
        }
        indexTree = new long[2 * s];
        initBU();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            //a = 1 update else query
            if (a == 1) {
                long diff = c - indexTree[s + b - 1];
                updateTD(1, s, 1, b, diff);
               // System.out.println(Arrays.toString(indexTree));
            } else {
                System.out.println(queryTD(1, s, 1, b, (int)c));
            }
        }

    }

    static void initBU() {

        for (int i = 1; i < leaf.length; i++) {//리프
            indexTree[s + i - 1] = leaf[i];
        }

        for (int i = s - 1; i >= 1; i--) {
            indexTree[i] = indexTree[i * 2] + indexTree[i * 2 + 1];
        }

       // System.out.println(Arrays.toString(indexTree));
    }

    static void updateTD(int left, int right, int node, int target, long diff) {
        //1.노드가 타겟 미포함
        if (target < left || target > right) {
            return;
        } else { //2.노드가 타겟 포함
            indexTree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                updateTD(left, mid, node * 2, target, diff);
                updateTD(mid + 1, right, node * 2 + 1, target, diff);
            }
        }

    }

    static long queryTD(int left, int right, int node, int queryLeft, int queryRight) {
        //1.노드가 쿼리 범위 밖
        if (right < queryLeft || left > queryRight) {
            return 0;
        }
        //2.노드가 쿼리 범위 안에 들어옴 - 판단가능
        else if (queryLeft <= left && queryRight >= right) {
            return indexTree[node];
        }
        //3.노드가 쿼리 범위에 걸쳐져있음 - 판단불가
        else {
            int mid = (left + right) / 2;
            long leftResult = queryTD(left, mid, node * 2, queryLeft, queryRight) ;
            long rightResult = queryTD(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return leftResult + rightResult;
        }
    }

}
