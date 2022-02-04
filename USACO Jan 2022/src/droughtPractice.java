import java.io.*;
import java.util.*;
public class droughtPractice {
    public static int[] hungerLevels;

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        int n = Integer.parseInt(b.readLine());

        for (int i = 0; i < n; i++) {
            int numberOfCows = Integer.parseInt(b.readLine());
            StringTokenizer line = new StringTokenizer(b.readLine());
            hungerLevels = new int[numberOfCows];
            for (int j = 0; j < numberOfCows; j++) {
                hungerLevels[j] = Integer.parseInt(line.nextToken());
            }


        }
    }
}