/*
ID: bryanch5
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.*;
public class palsquare {

    public static String convert (int a, int b, char[] bases) {
        String converted = "";
        while (a > 0) {
            int temp = a % b;
            converted+=bases[temp];
            a -= temp;
            a/=b;
        }
        return new StringBuilder(converted).reverse().toString();
    }

    public static void main(String args[]) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        char[] bases = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
        int base = Integer.parseInt(b.readLine());
        for (int i = 1; i <= 300; i++) {
            int s = i*i;
            String convertedsquare = convert(s, base, bases);
            String iterate = convert(i, base, bases);
            String reversesquare = new StringBuilder(convertedsquare).reverse().toString();
            if (reversesquare.equals(convertedsquare)) p.println(iterate+" "+convertedsquare);
        }
        b.close();
        p.close();
    }
}
