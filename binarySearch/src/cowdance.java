import java.io.*;
import java.util.*;

public class cowdance {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

        StringTokenizer st = new StringTokenizer(b.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(b.readLine());
        }

    }
}
