import java.io.*;
import java.util.*;

public class ArraySort {
    public static void main(String[] args) {
        List<int[]> testing = new ArrayList<int[]>();

        testing.add(0,new int[] {1,2});
        testing.add(1,new int[] {5,7});
        testing.add(2,new int[] {9,6});

        Collections.sort(testing, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for(int[] i : testing){
            System.out.println(Arrays.toString(i));
        }
    }
}
