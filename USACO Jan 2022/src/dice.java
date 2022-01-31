import java.io.*;
import java.util.*;
public class dice {
    public static boolean v12;
    public static boolean v13 = false;
    public static boolean v23 = false;

    public static boolean isPossible(int[] dice1, int[] dice2) {
        int beat = 0;
        int beaten = 0;
        for (int a = 1; a <= 10; a++) {
            for (int b = 1; b <= 10; b++) {
                for (int c = 1; c <= 10; c++) {
                    for (int d = 1; d <= 10; d++) {

                        int[] dice3 = new int[]{a,b,c,d};

                        if (v12 == true) {
                            if (doesBeat(dice3, dice1) == 1 && doesBeat(dice3, dice2) == -1){
                                return true;
                            }
                        }
                        if (v12 == false) {
                            if (doesBeat(dice3, dice1) == -1 && doesBeat(dice3, dice2) == 1){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int doesBeat(int[] dice1, int[] dice2) {
        // 1 denotes win, 0 denotes tie, -1 denotes loss
        int worse = 0;
        int better = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dice1[i] > dice2[j]) {
                    better++;
                }
                if (dice1[i] < dice2[j]) {
                    worse++;
                }
            }
        }
        if(better > worse) {
            return 1;
        }
        if(worse > better) {
            return -1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);

        int n = Integer.parseInt(b.readLine());
        int[] dice1 = new int[4];
        int[] dice2 = new int[4];

        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(b.readLine());
            for (int a = 0; a < 4; a++) {
                dice1[a] = Integer.parseInt(line.nextToken());
            }
            for (int a1 = 0; a1 < 4; a1++) {
                dice2[a1] = Integer.parseInt(line.nextToken());
            }
            if(doesBeat(dice1, dice2) == 0) {
                System.out.println("no");
                continue;
            }
            else if(doesBeat(dice1, dice2) == 1) {
                v12 = true;
                if (isPossible(dice1, dice2)) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }

            else if(doesBeat(dice1, dice2) == -1) {
                v12 = false;
                if (isPossible(dice1, dice2)) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }

        }
    }
}