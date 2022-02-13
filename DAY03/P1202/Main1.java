package DAY03.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Info{
    int weight,value;

    public Info(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
public class Main1 {
    static int n,k;
    static Info[] jewel;
    static int[] bag;
    static PriorityQueue<Info> pq;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[k];
        jewel = new Info[n];
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, Comparator.comparingInt(Info::getWeight));
        Arrays.sort(bag);
        pq = new PriorityQueue<>(Comparator.comparing(Info::getValue).reversed());
        int jIndex = 0;
        long ans = 0;
        for (int i = 0; i < bag.length; i++) {
            int capacity = bag[i];

            while (jIndex < n && jewel[jIndex].weight <= capacity) {
                pq.add(jewel[jIndex++]);
            }



            if (!pq.isEmpty()) {
                ans += pq.poll().value;
            }
        }
        System.out.println(ans);



    }

}
