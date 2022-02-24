import java.io.*;

public class moobuzz {
    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int n = Integer.parseInt(b.readLine());
        int numberCount = 1;
        int index = 1;
        int actualNumber = 0;
        while (numberCount < n) {
            if ((index % 3) == 0) {
                index++;
                continue;
            }
            else if ((index % 5) == 0) {
                index++;
                continue;
            }
            else {
                index++;
                numberCount++;
                actualNumber = index;
            }
        }
        p.println(actualNumber);

        b.close();
        p.close();
    }
}
