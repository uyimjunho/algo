package DAY03.P1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        MinHeap pq = new MinHeap();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                System.out.println(pq.delete());
            } else {
                pq.insert(input);
            }
        }
    }
}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        //1. leaf 마지막에 삽입
        list.add(val);

        int current = list.size() - 1;
        int parent = current / 2;

        //2. 부모와 비교 후 조건에 맞지 않으면 Swap
        //3. 조건이 만족되거나 root 까지 반복
        while (true) {
            if (parent == 0 || list.get(parent) <= list.get(current)) {
                break;
            }

            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete() {

        if (list.size() == 1) {
            return 0;
        }
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentPos = 1;

        while (true) {
            int lpos = currentPos * 2;
            int rpos = currentPos * 2 + 1;

            if (lpos >= list.size() - 1) {
                break;
            }

            int minValue = list.get(lpos);
            int minPos = lpos;

            if (rpos < list.size() && list.get(rpos) < minValue) {
                minValue = list.get(rpos);
                minPos = rpos;
            }

            if (list.get(currentPos) > minValue) {
                int tmp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos, tmp);

                currentPos = minPos;
            } else {
                break;
            }
        }
        return top;
    }
}