import java.io.*;
import java.util.*;

public class haybales{

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        StringTokenizer st = new StringTokenizer(b.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringTokenizer baleLoc = new StringTokenizer(b.readLine());
        int[] bales = new int[n];
        for(int i = 0; i < n; i++) {
            bales[i] = Integer.parseInt(baleLoc.nextToken());
        }

        Arrays.sort(bales);
        for(int i = 0; i < q; i++) {
            StringTokenizer st1 = new StringTokenizer(b.readLine());
            int begin = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());

//            p.println("begin = " + begin + "end = " + end);
            int left = Arrays.binarySearch(bales, begin);
//            System.out.println("left = " + left);
            if (left < 0) {
                left = Math.abs(left + 1);
            }
            int right = Arrays.binarySearch(bales, end);
//            System.out.println("right = " + right);
            if (right < 0) {
                right = Math.abs(right + 2);
            }
//            System.out.println("left = " + left + "right = " + right);
            p.println(right - left + 1);
        }
        b.close();
        p.close();
    }
}