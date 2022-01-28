package DAY01.P3055;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    char type;

    public Point(int x, int y, char type) {
        super();
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
public class Main {
    static boolean[][] wmap;//물
    static int[][] amap; //고슴도치
    static char[][] map;
    static int[][] visited;
    static Queue<Point> q;
    static boolean find;


    final static int[] DX = {-1, 1, 0, 0};
    final static int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        q = new LinkedList<>();
        map = new char[a][b];
        amap = new int[a][b];
        wmap = new boolean[a][b];

        Point start = null;
        for (int i = 0; i < a; i++) {//입력받음
            String str = sc.next();
            for (int j = 0; j < b; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == '*') {
                    wmap[i][j] = true;
                    q.add(new Point(i, j, '*'));
                } else if (str.charAt(j) == 'S') {
                    start = new Point(i, j, 'S');
                }
            }
        }
        q.add(start);

        //1.큐에서 꺼내옴
        //2.목적지인가
        //3.연결된곳 순회
        //  4.갈수있는가
        //      5.체크인
        //      6.큐에넣음

    }
}
