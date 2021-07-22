import java.io.*;
import java.util.*;

public class Fibonacci2 {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);
        int count = 0;
        int array[] = new int[n];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
            count++;
        }
        System.out.println("count = " + count);
        System.out.println(array[n-1]);
        System.out.println(Arrays.toString(array));

    }
}
