/*
ID: bryanch5
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gift1 {
    public static void main(String[] args) throws IOException {
        String f_name = "gift1";
        BufferedReader f = new BufferedReader(new FileReader(f_name + ".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f_name + ".out")));
        //StringTokenizer st = new StringTokenizer(f.readLine());
        int k = Integer.parseInt(f.readLine());
        String[] names = new String[k];
        int[] amounts = new int[k];
        for (int i = 0; i < k; i++) {
            names[i] = f.readLine();
        }
        for (int i = 0; i < k; i++) {
            String person = f.readLine();
            int p = Arrays.asList(names).indexOf(person);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            if (i2 > 0) {

                int amtAdd = i1 / i2;
                amounts[p] -= amtAdd * i2;
                for (int j = 0; j < i2; j++) {
                    String recipient = f.readLine();
                    int r = Arrays.asList(names).indexOf(recipient);
                    amounts[r] += amtAdd;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            out.println(names[i] + " " + amounts[i]);
        }
        out.close();
    }
}