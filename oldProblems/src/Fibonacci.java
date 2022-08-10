public class Fibonacci {
    static int count = 0;

    public static int algo(int n) {
        if (n <= 1) {
            count++;
            System.out.println(count);
            return n;
        }
        else {
            count++;
            System.out.println(count);
            return (algo(n-1) + algo(n-2));
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int number = algo(n);
        System.out.println(number);
        }
    }