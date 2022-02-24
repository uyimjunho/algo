package DAY03.P1655;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY03/P1655/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(Integer.parseInt(br.readLine()));
        System.out.println(maxHeap.peek());
        for (int i = 1; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            int maxP = maxHeap.peek();
            if (t > maxP) {
                minHeap.add(t);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            } else {
                maxHeap.add(t);
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            }

            //System.out.println(maxHeap.peek());
            bw.write(maxHeap.peek() + "\n");

        }
        bw.flush();
        bw.close();
        br.close();

    }


}
