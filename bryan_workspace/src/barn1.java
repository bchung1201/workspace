/*
ID: bryanch5
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.sql.Array;
import java.util.*;
public class barn1 {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer line = new StringTokenizer(b.readLine());
        int boardcount = Integer.parseInt(line.nextToken());
        int stallcount = Integer.parseInt(line.nextToken());
        int cowcount = Integer.parseInt(line.nextToken());
        int minimum = 0;
        ArrayList<Integer> cowspots = new ArrayList<Integer>();
        ArrayList<Integer> intervals = new ArrayList<Integer>();
        for (int i = 0; i < cowcount; i++) {
            cowspots.add(Integer.parseInt(b.readLine()));
        }
        Collections.sort(cowspots);
        minimum = 1 + cowspots.get(cowcount-1) - cowspots.get(0);
        for (int i = 0; i < cowcount - 1; i++) {
            intervals.add(cowspots.get(i + 1) - cowspots.get(i));
        }
        Collections.sort(intervals);
        Collections.reverse(intervals);
        int sum = 0;
        if(boardcount-1 > intervals.size()) {
            p.println(cowcount);
        }
        else {
            for (int i = 0; i < boardcount - 1; i++) {
                minimum -= intervals.get(i) - 1;
            }
            p.println(minimum);
        }
        b.close();
        p.close();
    }
}