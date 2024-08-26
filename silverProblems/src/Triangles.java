import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Triangles {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        int n = Integer.parseInt(b.readLine());

        int[][] postsX = new int[n][2];
        int[][] postsY = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(b.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            postsX[i][0] = x;
            postsY[i][0] = x;
            postsX[i][1] = y;
            postsY[i][1] = y;

        }

        Arrays.sort(postsX, (a, c) -> {
            // If the values in the second column are equal,
            // sort by the values in the first column
            if (a[1] == c[1]) {
                return a[0] - c[0];
            }
            // Otherwise, sort by the values in the second column
            return a[1] - c[1];
        });

        Arrays.sort(postsY, (a, c) -> {
            // If the values in the second column are equal,
            // sort by the values in the first column
            if (a[0] == c[0]) {
                return a[1] - c[1];
            }
            // Otherwise, sort by the values in the second column
            return a[0] - c[0];
        });

//        for (int[] row : postsX) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//        for (int[] row : postsY) {
//            System.out.println(Arrays.toString(row));
//        }


        ArrayList<int[]> sumsX = new ArrayList<>();
        ArrayList<int[]> sumsY = new ArrayList<>();


    }
}