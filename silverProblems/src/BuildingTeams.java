import java.io.*;
import java.util.*;

public class BuildingTeams {
    public static ArrayList<Integer> adj[];
    public static ArrayList<Integer> partner = new ArrayList<Integer>();
    public static boolean visited[];

    public static void main (String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(b.readLine());
        int n = Integer.parseInt(b.readLine());
        int m = Integer.parseInt(b.readLine());
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            StringTokenizer st1 = new StringTokenizer(b.readLine());
            int initial = Integer.parseInt(st.nextToken());
            int ending = Integer.parseInt(st.nextToken());
            adj[initial].add(ending); adj[ending].add(initial);
        }
        int ans = countComponents();
        p.println(ans-1);
        for (int i = 1; i < ans; i++){
            p.println(partner.get(i-1) + " " + partner.get(i));
        }
        p.close();
    }

    public static int countComponents() {
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                count++;
                partner.add(i);
                dfs(i);
            }
        }
        return count;
    }

    public static void dfs(int node) {
        visited[node] = true;
        for(int u : adj[node]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }
}
