package DAY03.P11279;

import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxHeap {
    List<Integer> Heap;

    public MaxHeap() {
        Heap = new ArrayList<Integer>();
        Heap.add(0);
    }

    public void insert(int val) {
        Heap.add(val);
        int currentPos = Heap.size() - 1;
        int parent = currentPos / 2;

        while (true) {
            if (parent == 0 || Heap.get(currentPos) < Heap.get(parent)) {
                break;
            }

            Collections.swap(Heap, currentPos, parent);
            currentPos = parent;
            parent = currentPos / 2;
        }
    }

    public int delete() {
        if (Heap.size() == 1) {
            return 0;
        }
        int top = Heap.get(1);
        Collections.swap(Heap, 1, Heap.size() - 1);
        Heap.remove(Heap.size() - 1);
        int currentPos = 1;

        while (true) {
            int leftchild = currentPos * 2;
            int rightchild = currentPos * 2 + 1;

            if (leftchild >= Heap.size()) {
                break;
            }

            int maxValue = Heap.get(leftchild);
            int maxPos = leftchild;

            if (rightchild < Heap.size() && Heap.get(rightchild) > maxValue) {
                maxValue = Heap.get(rightchild);
                maxPos = rightchild;
            }

            if (Heap.get(currentPos) < maxValue) {
                Collections.swap(Heap, maxPos, currentPos);
                currentPos = maxPos;
            } else {
                break;
            }
        }
        return top;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                System.out.println(maxHeap.delete());
            } else {
                maxHeap.insert(tmp);
            }
        }
    }
}
