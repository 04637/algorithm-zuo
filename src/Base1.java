import java.util.Arrays;
import java.util.Random;

public class Base1 {

    public static void main(String[] args) {
        final int m = 10;
        final int n = 5;
        int[] ma = new int[m];
        int[] na = new int[n];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            ma[i] = rand.nextInt(100);
        }
        for (int i = 0; i < n; i++) {
            na[i] = rand.nextInt(100);
        }
        Arrays.sort(ma);
        Arrays.sort(na);

        System.out.println("ma: " + Arrays.toString(ma));
        System.out.println("na: " + Arrays.toString(na));
        for (int a = 0, b = 0; a < m && b < n; ) {
            if (ma[a] < na[b]) {
                a++;
            } else if (ma[a] > na[b]) {
                System.out.print(na[b]+", ");
                b++;
            } else {
                b++;
            }
        }
    }



}
