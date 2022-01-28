package DAY04.P3955;

public class Main {
    static int N;
    static int A;
    static int B;

    public static void main(String[] args) {
        //X : 인당 나눠줄 사탕의 수
        //y : 사탕 봉지의 수
        //A * x + 1 = B * Y
        //Ax + By = C로 변환
        //-Ax + By = 1
        //A(-x) + By = 1
    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;
        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }
}