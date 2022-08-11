import java.io.*;
import java.util.*;

public class Cowntagion {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        int n = Integer.parseInt(b.readLine());
        ArrayList<Integer> graf[] = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graf[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(b.readLine());
            int a = Integer.parseInt(st.nextToken());
            int br = Integer.parseInt(st.nextToken());
            graf[a].add(br);
            graf[br].add(a);
        }
        int day = 0;
        Stack<Integer> stak = new Stack<>(); //named for david
        HashSet<Integer> set = new HashSet<>();
        stak.push(1);

        while(!stak.isEmpty()) {
            int cur = stak.pop();
            if (set.contains(cur)) {
                continue;
            }
            set.add(cur);
            int children = 0;
            for (int i : graf[cur]) {
                if (set.contains(i)) {
                    continue;
                }
                stak.push(i);
                children++;
            }
            int count = 0;
            while (!(Math.pow(2,count) > children)) {
                count++;
            }

            day = day + count + children;
        }

        p.println(day);

        b.close();
        p.close();
    }
}
