package DAY03.P1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int weight, value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class Main {

    static int N;
    static int K;
    static Pair[] jewel;
    static int[] bag;
    static PriorityQueue<Pair> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewel = new Pair[N];
        bag = new int[K];
        pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue).reversed());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jewel[i] = new Pair(a, b);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            bag[i] = a;
        }

        Arrays.sort(bag);
        Arrays.sort(jewel,Comparator.comparing(Pair::getWeight).reversed());

        int now = 0;
        long ans = 0;
        for (int i = 0; i < bag.length; i++) {
            int tmp = bag[i];
            while (now < N && jewel[now].getWeight() <= tmp) {
                pq.add(jewel[now++]);
            }

            if (!pq.isEmpty()) {
                ans += pq.peek().getValue();
                pq.poll();
            }
        }
        System.out.println(ans);
    }
}
