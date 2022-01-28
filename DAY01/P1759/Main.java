package DAY01.P1759;

import java.util.*;

public class Main {
    static boolean[] visited;
    static String[] ans;
    static int l,c;
    static char[] data;
    static List<String> result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();
        data = new char[c];
        result = new LinkedList<>();

        for (int i = 0; i < c; i++) {
            data[i] = sc.next().charAt(0);
        }

        System.out.println(Arrays.toString(data));
        Arrays.sort(data);


        dfs(0, 0, 0, -1, "");


        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }


    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        //1.체크인 - 생략가능
        //2.목적지인가 - 길이 + 자음 모음 갯수
        if (length == l) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        } else {


            //3.연결된곳 순회 - 나보다 높은 알파벳
            for (int nextIndex = current + 1; nextIndex < data.length; nextIndex++) {
                char nextData = data[nextIndex];
                //4.    갈수있는가 - 정렬로 해결 이미 함 -- 생략
                if (nextData == 'a' || nextData == 'e' || nextData == 'i' || nextData == 'o' || nextData == 'u') {
                    //  5.  간다 - dfs(nextData) -> 모음
                    dfs(length + 1, ja, mo + 1, nextIndex, pwd + nextData);
                } else {
                    //  5.  간다 - dfs(nextData) -> 자음
                    dfs(length + 1, ja + 1, mo, nextIndex, pwd + nextData);
                }
                //5.        간다 - dfs(nextData) 자음,모음


            }
        }

        //6.체크아웃 - 생략가능
    }
}
