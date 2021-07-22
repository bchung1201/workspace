/*
ID: bryanch5
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        String l = b.readLine();
        StringTokenizer line = new StringTokenizer(l);
        int N = Integer.parseInt(line.nextToken());
        int S = Integer.parseInt(line.nextToken());
        int numbercount = 0;
        for (int i = S + 1; numbercount < N; i++) {
            int basecount = 0;
            for (int j = 2; j <= 10; j++) {
                String result = Integer.toString(i, j);
                String reverse = new StringBuilder(result).reverse().toString();
                if (reverse.equals(result)) {
                    basecount++;
                }
                if (basecount >= 2) {
                    break;
                }
            }
            if (basecount >= 2) {
                numbercount++;
                p.println("number = " + i + " basecount = " + basecount);
            }
        }
        b.close();
        p.close();
    }
}
