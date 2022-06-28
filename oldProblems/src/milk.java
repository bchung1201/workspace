/*
ID: bryanch5
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;
public class milk {

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("milk.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer n = new StringTokenizer(b.readLine());
        int totalneeded = Integer.parseInt(n.nextToken());
        int totalfarmers = Integer.parseInt(n.nextToken());
        List<int[]> priceamounts = new ArrayList<int[]>();

        for (int i = 0; i < totalfarmers; i++) {
            StringTokenizer line = new StringTokenizer(b.readLine());
            int price = Integer.parseInt(line.nextToken());
            int amount = Integer.parseInt(line.nextToken());
            priceamounts.add(i,new int[] {price,amount});
        }
        Collections.sort(priceamounts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int finalprice = 0;
        int i = 0;
        for(i = 0; i<priceamounts.size() && totalneeded > 0; i++){
            totalneeded -= priceamounts.get(i)[1];
            finalprice += priceamounts.get(i)[0] * priceamounts.get(i)[1];
        }
        if (totalneeded !=0) {
            finalprice += totalneeded*priceamounts.get(i-1)[0];
            totalneeded-=totalneeded;
        }
        p.println(finalprice);
        b.close();
        p.close();
    }
}