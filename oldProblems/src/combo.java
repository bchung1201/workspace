/*
ID: bryanch5
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.sql.Array;
import java.util.*;
public class combo {
    public static boolean valid(int a, int b, int n){
        return (Math.min( Math.min( Math.abs(a-b), Math.abs((a-b)+n) ), Math.abs( (a-b)-n) ) <= 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("combo.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int n = Integer.parseInt(b.readLine());
        StringTokenizer john = new StringTokenizer(b.readLine());
        int john1 = Integer.parseInt(john.nextToken());
        int john2 = Integer.parseInt(john.nextToken());
        int john3 = Integer.parseInt(john.nextToken());
        StringTokenizer master = new StringTokenizer(b.readLine());
        int master1 = Integer.parseInt(master.nextToken());
        int master2 = Integer.parseInt(master.nextToken());
        int master3 = Integer.parseInt(master.nextToken());

        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if((valid(i, john1, n) && valid(j, john2, n) && valid(k, john3, n)) || (valid(i, master1, n) && (valid(j, master2, n) && valid(k, master3, n)))) {
                        count++;
                    }
                }
            }
        }
        p.println(count);
        b.close();
        p.close();
    }
}