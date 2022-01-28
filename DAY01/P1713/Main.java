package DAY01.P1713;

import java.util.Scanner;

class Student implements Comparable<Student> {
    int count;
    int oldest;

    public Student(int count, int oldest) {
        this.count = count;
        this.oldest = oldest;
    }

    @Override
    public int compareTo(Student o) {
        int com1 = Integer.compare(count, o.count);
        if (com1 == 0) {
            return Integer.compare(oldest, o.oldest);
        }
        return com1;
    }


}
public class Main {
    static int N;
    static int candi;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        candi = sc.nextInt();
        arr = new int[candi];
        for (int i = 0; i < candi; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
    }
}
