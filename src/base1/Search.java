package base1;

import java.util.Arrays;
import java.util.Random;

/**
 * 输出na中不存在于ma中的元素
 * 例: ma [1,3,5,9,12] na[2,3,5,7,10]
 * 输出: 2,7
 *
 */
public class Search {

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
