import java.io.*;
import java.util.*;

public class revegetate {
    static int N;
    static int M; //hi im bryan
    static ArrayList<ArrayList<Integer>> same = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> diff = new ArrayList<>();
    static int[] grass;

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(b.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grass = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            same.add(new ArrayList<>());
            diff.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(b.readLine());
            char c = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (c == 'S') {
                same.get(a).add(d);
                same.get(d).add(a);
            } else {
                diff.get(a).add(d);
                diff.get(d).add(a);
            }
        }
        b.close();

        Arrays.fill(grass, -1);
        boolean validOTS = true;
        int count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (grass[i] == -1) {
                if (!dfs(i, 0)) {
                    validOTS = false;
                }
                count++;
            }
        }

        if(!validOTS) {
            p.println(0);
        }
        else {
            str.append(1);
            for (int i = 0; i < count; i++) {
                str.append(0);
            }
            p.println(str);
        }

        b.close();
        p.close();
    }

    // 1 2 3 4 5 6
    // 1 0 1 0 0 1
    // jit bussin
    // how many words can bryan put jit in front of???
    public static boolean dfs(int node, int toFill /* 0 or 1 */) {
        grass[node] = toFill;
        for (int i : same.get(node)) {
            //if it is already colored in but filled oppositely it proves a contradiction so return false ////"oppositely"
            if (grass[i] == 1 - toFill) {
                return false;
            }
            if (grass[i] == -1) {
                dfs(i, toFill);
            }
        }

        for (int i : diff.get(node)) {
            if (grass[i] == toFill) {
                return false;
            }
            if (grass[i] == -1) {
                dfs(i, 1 - toFill);
            }
        }
        return true;
    }
}
