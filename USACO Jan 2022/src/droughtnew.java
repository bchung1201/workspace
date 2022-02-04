import java.io.*;
import java.util.*;
public class droughtnew {
    public static int count = 0;
    public static int[] hungerLevels;
    static int numberOfCows;
    // hi

    public static void canReduce() {
        if(allEqual(hungerLevels)) {
            System.out.println(count*2);
            return;
        }
        int largestIndex = findLargestIndex(hungerLevels);
        if(allPositive(hungerLevels) == false) {
            System.out.println("-1");
            return;
        }
        else if ((hungerLevels[0] > hungerLevels[1]) || (hungerLevels[numberOfCows-1] > hungerLevels[numberOfCows-2])){
            System.out.println("-1");
            return;
        }
        else {
            if (largestIndex == 0) {
//                System.out.println("current = " + Arrays.toString(hungerLevels));
                hungerLevels[largestIndex+1] = hungerLevels[largestIndex+1] - 1;
                hungerLevels[largestIndex] = hungerLevels[largestIndex] - 1;
//                System.out.println("edited = " + Arrays.toString(hungerLevels));
                count++;
                canReduce();
            }
            else if (largestIndex == hungerLevels.length - 1) {
//                System.out.println("current = " + Arrays.toString(hungerLevels));
                hungerLevels[largestIndex-1] = hungerLevels[largestIndex-1] - 1;
                hungerLevels[largestIndex] = hungerLevels[largestIndex] - 1;
//                System.out.println("edited = " + Arrays.toString(hungerLevels));
                count++;
                canReduce();
            }
            else if (hungerLevels[largestIndex-1] >= hungerLevels[largestIndex+1]) {
//                System.out.println("current = " + Arrays.toString(hungerLevels));
                int reduceAmt = (hungerLevels[largestIndex-1] - hungerLevels[largestIndex+1]);
                if (reduceAmt == 0) {
                    reduceAmt = 1;
                }
                hungerLevels[largestIndex-1] = hungerLevels[largestIndex-1] - reduceAmt;
                hungerLevels[largestIndex] = hungerLevels[largestIndex] - reduceAmt;
//                System.out.println("edited = " + Arrays.toString(hungerLevels));
                count = count + reduceAmt;
                canReduce();
            }
            else {
                //              System.out.println("current = " + Arrays.toString(hungerLevels));
                int reduceAmt = (hungerLevels[largestIndex+1] - hungerLevels[largestIndex-1]);
                if (reduceAmt == 0) {
                    reduceAmt = 1;
                }
                hungerLevels[largestIndex+1] = hungerLevels[largestIndex+1] - reduceAmt;
                hungerLevels[largestIndex] = hungerLevels[largestIndex] - reduceAmt;
                //               System.out.println("edited = " + Arrays.toString(hungerLevels));
                count = count + reduceAmt;
                canReduce();
            }
        }


    }

    public static int findLargestIndex(int[] array) {
        int largest = 0;
        for (int j = 1; j < array.length; j++) {
            if(array[largest] < array[j]) {
                largest = j;
            }

        }
        return largest;
    }

    public static boolean allEqual(int[] array) {
        int first = array[0];
        for (int j = 0; j < array.length; j++) {
            if(array[j] != first) {
                return false;
            }
        }
        return true;
    }

    public static boolean allPositive(int[] array) {
        for (int j = 0; j < array.length; j++) {
            if(array[j] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(System.out);
        int n = Integer.parseInt(b.readLine());

        for (int i = 0; i < n; i++) {
            count = 0;
            int numberOfCows = Integer.parseInt(b.readLine());
            StringTokenizer line = new StringTokenizer(b.readLine());

            hungerLevels = new int[numberOfCows];

            for (int j = 0; j < numberOfCows; j++) {
                hungerLevels[j] = Integer.parseInt(line.nextToken());
            }
            canReduce();
        }
    }
}