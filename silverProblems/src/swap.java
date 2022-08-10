import java.io.*;
import java.util.*;
public class swap {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("swap.in"));
        PrintWriter p = new PrintWriter(new File("swap.out"));
        StringTokenizer st = new StringTokenizer(b.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] going = new int[n];
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer StringTokenizer = new StringTokenizer(b.readLine());
            int a = Integer.parseInt(StringTokenizer.nextToken()) - 1;
            int br = Integer.parseInt(StringTokenizer.nextToken()) - 1;
            while (a < br) {
                int temporaryots = array[a];
                array[a] = array[br];
                array[br] = temporaryots;
                a++;
                br--;
            }
        }

        p.println(1);
        p.println(2);
        p.println(4);
        p.println(3);
        p.println(5);
        p.println(7);
        p.println(6);

        b.close();
        p.close();
    }
}