import java.io.*;
import java.util.*;

public class ConnectingTwoBarns {

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        int numCases = Integer.parseInt(b.readLine());

        for (int j = 0; j < numCases; j++) {
            StringTokenizer st1 = new StringTokenizer(b.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(b.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u-1).add(v-1);
                adj.get(v-1).add(u-1);
            }

            int[] componentNum = new int[n];
            for (int i = 0; i < n; i++) {
                componentNum[i] = -1;
            }
            int component = 0;
            for (int i = 0; i < n; i++) {
                if (componentNum[i] == -1) {
                    Stack<Integer> stak = new Stack<>(); //named for david
                    stak.push(i);
                    while (!stak.isEmpty()) {
                        int cur = stak.pop();
                        if (componentNum[cur] != -1) {
                            continue;
                        }
                        componentNum[cur] = component;
                        for (int neighbor: adj.get(cur)) {
                            stak.push(neighbor);
                        }
                    }
                    component++;
                }
            }

            List<List<Integer>> components = new ArrayList<>();
            for (int i = 0; i < component; i++) {
                components.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                components.get(componentNum[i]).add(i);
            }
            List<Integer> componentWith0 = components.get(componentNum[0]);
            List<Integer> componentWithN = components.get(componentNum[n - 1]);
            long[] distFromStart = new long[component];
            long[] distFromEnd = new long[component];
            Arrays.fill(distFromStart, Long.MAX_VALUE);
            Arrays.fill(distFromEnd, Long.MAX_VALUE);
            int barn1Index = 0;
            for (int i = 0; i < n; i++) {
                int dist = Math.abs(componentWith0.get(barn1Index) - i);
                while (barn1Index < componentWith0.size() - 1 && Math.abs(componentWith0.get(barn1Index+1) - i) < dist) {
                    barn1Index++;
                }
                distFromStart[componentNum[i]] = Math.min(dist,distFromStart[componentNum[i]]);
            }

            int barn2Index = 0;
            for (int i = 0; i < n; i++) {
                int dist = Math.abs(componentWithN.get(barn2Index) - i);

                while (barn2Index < componentWithN.size() - 1 && Math.abs(componentWithN.get(barn2Index + 1) - i) < dist) {
                    barn2Index++;
                }
                distFromEnd[componentNum[i]] = Math.min(dist, distFromEnd[componentNum[i]]);
            }

            long min = Long.MAX_VALUE;
            for (int i = 0; i < component; i++) {
                long cost = distFromStart[i] * distFromStart[i] + distFromEnd[i] * distFromEnd[i];
                min = Math.min(min, cost);
            }
            p.println(min);
        }
        b.close();
        p.close();
    }
}
