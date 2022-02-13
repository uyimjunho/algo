package DAY01.P3055;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 좌, 우, 위, 아래
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};

    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> q;
    static boolean foundAnswer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY01/P3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        q = new LinkedList<>();

        Point st = null;
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'S') {
                    st = new Point(r, c, 'S');
                } else if (map[r][c] == '*') {
                    q.add(new Point(r, c, '*'));
                }
            }
        }
        q.add(st);

//        for (int r = 0; r < R; r++) {
//            System.out.println(Arrays.toString(map[r]));
//        }

        while (!q.isEmpty()) {
            //1.큐에서 꺼내옴
            Point p = q.poll();
            //2.목적지인가
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                foundAnswer = true;
                break;
            }
            //3.연결된곳 순회  u.x + dx u.y + dy 하면서 탐색
            for (int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                //  4.갈수있는가   wmap == false
                if (0 <= ty && ty < R && 0 <= tx && tx < C) {
                    if (p.type == '.' || p.type == 'S') {//고슴도치
                        if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            q.add(new Point(ty, tx, map[ty][tx]));
                        }
                    } else if (p.type == '*') {
                        if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            map[ty][tx] = '*';
                            q.add(new Point(ty, tx, '*'));
                        }
                    }
                }
            }

            //      5.체크인
            //      6.큐에넣음   q.push(next)

        }

        if (foundAnswer == false) {
            System.out.println("KAKTUS");
        }

    }
}

class Point {
    int y;
    int x;
    char type;

    public Point(int y, int x, char type) {
        super();
        this.y = y;
        this.x = x;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[y=" + y + ", x=" + x + ", type=" + type + "]";
    }
}
