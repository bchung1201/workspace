/*
ID: bryanch5
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int cows = Integer.parseInt(b.readLine());
        List<Integer> start = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        String sequence = "";

        while ((sequence = b.readLine()) != null) {
            StringTokenizer i = new StringTokenizer(sequence);
            int s = Integer.parseInt(i.nextToken());
            int e = Integer.parseInt(i.nextToken());
            int ii = 0;
            for (ii = 0; ii < start.size(); ii++) {
                if (start.get(ii) > s) {
                    break;
                }
            }
            start.add(ii, s);
            end.add(ii, e);
        }
        for (int i = 0; i <cows; i++) {
            loop: for (int a = 0; a < start.size(); a++) {
                for (int c = 0; c < start.size(); c++) {
                    if (a != c) {

                        if(start.get(a) > start.get(c)) {
                            if(start.get(a) <= end.get(c)) {
                                if (end.get(a) >= end.get(c)) {
                                    end.set(c, end.get(a));
                                }
                                start.remove(a);
                                end.remove(a);
                                break loop;
                            }
                        }
                        else {
                            if (end.get(a) >= start.get(c)) {
                                if (end.get(a) <= end.get(c)) {
                                    end.set(a, end.get(c));
                                }
                                start.remove(c);
                                end.remove(c);
                                break loop;
                            }
                        }
                    }
                }
            }

        }
        int max = 0;
        int not = 0;
        for (int i = 0; i < start.size(); i++) {
            int length = end.get(i) - start.get(i);
            int no = 0;
            if (i + 1 < start.size()) {
                no = start.get(i+1) - end.get(i);
            }
            max = Math.max(max, length);
            not = Math.max(not, no);
        }
        p.println(max + " " + not);
        b.close();
        p.close();
    }
}