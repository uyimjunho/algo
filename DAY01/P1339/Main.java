package DAY01.P1339;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.CheckedOutputStream;

public class Main {
    static int N;
    static List<String> arr;
    static int[] alphabet;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/DAY01/P1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr.add(word);
        }

        for (int i = 0; i < N; i++) {
            int l = arr.get(i).length()-1;
            for (int j = 0; j < arr.get(i).length(); j++) {
                int idx = arr.get(i).charAt(j) - 'A';
                alphabet[idx] += Math.pow(10, l);
                l--;
            }
        }

//        System.out.println(Arrays.toString(alphabet));
//        Arrays.sort(alphabet, Collections.reverseOrder())
        Arrays.sort(alphabet);
        int tmp = 9;
        int ans = 0;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0) {
                break;
            }
            ans += alphabet[i] * tmp;
            tmp--;
        }
        System.out.println(ans);
//        System.out.println(Arrays.toString(alphabet));

    }
}
