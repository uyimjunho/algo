package DAY07.P1753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class Main {
    static ArrayList<Pair>[] arr;
    static int V;
    static int K;//시작정저
    static int E;
    static int[] ans;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY07/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

//        System.out.println(K);
        arr = new ArrayList[V+1];
        ans = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            arr[i] = new ArrayList<>();
            ans[i] = INF;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getWeight));
        for (int i = 0; i < E; i++) {
            int s,e,w;
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr[s].add(new Pair(e, w));

        }

        pq.add(new Pair(K,0));
        ans[K] = 0;
        while (!pq.isEmpty()) {
            Pair tmp = pq.poll();

            for (int i = 0; i < arr[tmp.getVertex()].size(); i++) {
                Pair next = arr[tmp.getVertex()].get(i);
                int nextV = next.vertex;
                int nextW = next.weight;

                if (ans[nextV] > ans[tmp.getVertex()] + nextW) {
                    ans[nextV] = ans[tmp.getVertex()] + nextW;
                    pq.add(new Pair(nextV, ans[nextV]));
                }
            }
        }
        for (int i = 1; i < V + 1; i++) {
            if (ans[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(ans[i]);
            }
        }
    }
}
