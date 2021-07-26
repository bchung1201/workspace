/*
ID: bryanch5
LANG: JAVA
TASK: milk
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
        minimum = cowspots.get(cowcount) - cowspots.get(0);
        for (int i = 0; i < cowcount - 1; i++) {
            intervals.add(cowspots.get(i + 1) - cowspots.get(i));
        }
        Collections.sort(intervals);
        Collections.reverse(intervals);
        int sum = 0;
        for(int i = 0; i<boardcount; i++){
            sum =+ intervals.get(i);
        }
        p.println(minimum - sum);
    }
}