import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(recur(n, r, c));
    }

    private static int recur(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) return recur(n - 1, r, c);
        if (r < half && c >= half) return half * half + recur(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + recur(n - 1, r - half, c);
        return 3 * half * half + recur(n - 1, r - half, c - half);
    }
}
