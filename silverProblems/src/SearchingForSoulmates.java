import java.io.*;
import java.util.*;

public class SearchingForSoulmates {

    public static int numberOfOperations(int initial, int desired) {
        int count = 0;
        int count2 = 0;
        while (initial != desired) {
            if ((initial > desired) && (initial % 2 == 1)) {
                initial++;
                count++;
//                System.out.println("initial = " + initial);
//                System.out.println("count = " + count);
                continue;
            }

            if ((initial > desired) && (initial % 2 == 0)) {
                initial = initial/2;
                count++;
//                System.out.println("initial = " + initial);
//                System.out.println("count = " + count);
                continue;
            }

//            if ((initial > desired/2) && (initial < desired)) {
//                count += (desired - initial);
////                System.out.println("initial = " + initial);
////                System.out.println("count = " + count);
//                return count;
//            }

            count2 = count;

            count2 += desired - initial;

            int simplified = desired;
            int power = 0;
            while (simplified % 2 == 0) {
                power++;
                simplified /= 2;
            }

            while (initial != simplified) {
                if ((initial > simplified) && (initial % 2 == 1)) {
                    initial++;
                    count++;
//                    System.out.println("initial = " + initial);
//                    System.out.println("count = " + count);
                    continue;
                }

                if ((initial > simplified) && (initial % 2 == 0)) {
                    initial = initial / 2;
                    count++;
//                    System.out.println("initial = " + initial);
//                    System.out.println("count = " + count);
                    continue;
                } else {
                    initial++;
                    count++;
                }
            }

            initial = initial * (int) Math.pow(2, power);
            count += power;

        }
        return Math.min(count, count2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(b.readLine());
            int initial = Integer.parseInt(st.nextToken());
            int desired = Integer.parseInt(st.nextToken());

            System.out.println(numberOfOperations(initial,desired));
        }

    }
}
