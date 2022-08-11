import java.util.*;
import java.io.*;

public class Visiting {
    static int[] a;
    static int[] v;
    static boolean[] done;
    static ArrayList<ArrayList<Integer>> child = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> child = new ArrayList<>();
        a = new int[N+1];
        v = new int[N+1];
        for (int i = 0; i <= N; i++) {
            child.add(new ArrayList<>());
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            ans += v[i];
            child.get(a[i]).add(i);
        }
        done = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!done[i]) ans -= solve(i);
        }
        System.out.println(ans);
    }
    public static int solve(int start) {
        int x = start;
        int y = start;
        do {
            x = a[x];
            y = a[a[y]];
        } while (x != y);
        int min_along_cycle = Integer.MAX_VALUE;
        do {
            min_along_cycle = Math.min(min_along_cycle, v[x]);
            x = a[x];
        } while (x != y);
        mark_as_done(x);
        return min_along_cycle;
    }
    public static void mark_as_done(int x) {
        if (done[x]) return;
        done[x] = true;
        for (int c : child.get(x)) mark_as_done(c);
    }
}