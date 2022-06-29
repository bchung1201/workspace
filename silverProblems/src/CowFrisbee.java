import java.io.*;
import java.util.*;

public class CowFrisbee {
    public static class Cow {
        long index;
        long height;

        public Cow(long ind, long hei) {
            index = ind;
            height = hei;
        }
    }

    public static void main(String[] args) throws java.io.IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        long n = Integer.parseInt(b.readLine());
        StringTokenizer st = new StringTokenizer(b.readLine());
        Cow[] cows = new Cow[(int) n];
        for (int i = 0; i < n; i++) {
            cows[i] = new Cow(i, Integer.parseInt(st.nextToken()));
        }
        Stack<Cow> stack = new Stack<Cow>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.add(cows[i]);
                continue;
            }
            else if (stack.peek().height > cows[i].height) {
                stack.add(cows[i]);
                count += 2;
                continue;
            }

            while (!stack.isEmpty() && stack.peek().height < cows[i].height) {
                count += i - stack.pop().index + 1;
            }

            if (stack.isEmpty()) {
                stack.add(cows[i]);
            }
            else {
                count += i - stack.peek().index + 1;
                stack.add(cows[i]);
            }
        }

        p.println(count);

        b.close();
        p.close();
    }
}
