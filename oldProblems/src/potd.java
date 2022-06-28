public class potd {
    public static void main(String[] args) {
        int position;
        int end1 = 0;
        int end5 = 0;
        boolean hello = true;
        for (int i = 0; i < 1000000000; i++) {
            position = 1;
            while (hello) {
                int randomizer = (int) (3 * Math.random());
                if (randomizer == 0 || randomizer == 1) {
                    position++;
                }
                else{
                    position--;
                }
                if (position == 5) {
                    end5++;
                    break;
                }
                if (position == 1) {
                    end1++;
                    break;
                }
            }
        }
        System.out.println(end5 + "/" + end1);
    }
}
