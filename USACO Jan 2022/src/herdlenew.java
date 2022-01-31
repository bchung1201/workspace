import java.io.*;
import java.util.*;
public class herdlenew {
    public static char[][] sol = new char[3][3];
    public static char[][] guess = new char[3][3];

    public static boolean isYellow(int a, int b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guess[a][b] == sol[i][j]) {
//                    System.out.println (a + " " + b + " " + i + " " + j);
                    sol[i][j] = '1';
                    return true;
                }
                else {
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);

        for (int i = 0; i < 3; i++) {
            String line = b.readLine();
            for (int j = 0; j < 3; j++) {
                sol[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < 3; i++) {
            String line = b.readLine();
            for (int j = 0; j < 3; j++) {
                guess[i][j] = line.charAt(j);
            }
        }

//        System.out.println(Arrays.deepToString(sol));
//        System.out.println(Arrays.deepToString(guess));

        int greens = 0;
        int yellows = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                System.out.println(Arrays.deepToString(sol));
//                System.out.println(Arrays.deepToString(guess));

                if (sol[i][j] == guess[i][j]) {
                    greens++;
//                    System.out.println("green detect");
//                    System.out.println("green guess char = " + guess[i][j]);
                    sol[i][j] = '0';
                    guess[i][j] = '0';
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(guess[i][j] == '0') {
                    continue;
                }
                if (isYellow(i, j)) {
                yellows++;
//                    System.out.println("yellow detect");
//                    System.out.println("yellow guess char = " + guess[i][j]);
                }
            }
        }
        System.out.println(greens);
        System.out.println(yellows);

        b.close();
        p.close();
    }
}