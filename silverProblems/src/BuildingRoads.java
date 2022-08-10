import java.io.*;
import java.util.*;

public class BuildingRoads {
    public static ArrayList<Integer> adj[];
    public static boolean visited[];
    public static ArrayList<Integer> rep = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(b.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(b.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        int ans = count_components();
        p.println(ans-1);
        for (int i = 1; i < ans; i++){
            p.println(rep.get(i-1) + " " + rep.get(i));
        }
        b.close();
        p.close();
    }
    public static void dfs(int node)
    {
        visited[node] = true;
        for (int u: adj[node])
            if(!visited[u])
                dfs(u);
    }
    public static int count_components()
    {
        int count = 0;
        for (int i = 1; i <= adj.length-1; i++){
            if(!visited[i]){
                count++;
                rep.add(i);
                dfs(i);
            }
        }
        return count;
    }
}
