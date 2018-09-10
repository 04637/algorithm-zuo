package base1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 输出ma中不存在于na中的元素
 * na为有序数组, 长度N, ma无序, 长度M
 * 例: na [1,3,5,9,12] ma[7,2,5,3,10]
 * 输出: 2,7
 */
public class Search {

    public static void main(String[] args) {
        final int n = 10;
        final int m = 5;
        int[] na = new int[m];
        int[] ma = new int[n];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            na[i] = rand.nextInt(100);
        }
        for (int i = 0; i < n; i++) {
            ma[i] = rand.nextInt(100);
        }
        Arrays.sort(na);
        List<Integer> result = binarySearch(na, ma);
        System.out.println(result);
    }


    /**
     * 二分
     * 时间复杂度: O(M*logN)
     * @param na 有序数组
     * @param ma 无序数组
     */
    public static List<Integer> binarySearch(int[] na, int[] ma) {
        List<Integer> result = new ArrayList<>();
        System.out.println("na: " + Arrays.toString(na));
        System.out.println("ma: " + Arrays.toString(ma));
        for (int i = 0; i < ma.length; i++) {
            int left = 0;
            int right = na.length - 1;
            int mid = (right - left) >>> 2;
            boolean exists = false;
            for (; left <= right; ) {
                if (ma[i] < na[mid]) {
                    right = mid - 1;
                    mid = (right + left) >>> 2;
                } else if (ma[i] > na[mid]) {
                    left = mid + 1;
                    mid = (right + left) >>> 2;
                } else {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                result.add(ma[i]);
            }
        }

        return result;

    }

    /**
     * 外排     排序复杂度↓
     * 时间复杂度: O(M*logM)+O(N+M)
     * @param na 有序数组
     * @param ma 需要对其排序
     * @return result
     */
    public static List<Integer> search(int[] na, int[] ma) {
        int m = na.length;
        int n = ma.length;
        Arrays.sort(ma);
        System.out.println("na: " + Arrays.toString(na));
        System.out.println("ma: " + Arrays.toString(ma));
        int a = 0;
        int b = 0;
        List<Integer> result = new ArrayList<>();
        for (; a < m && b < n; ) {
            if (na[a] < ma[b]) {
                a++;
            } else if (na[a] > ma[b]) {
                result.add(ma[b]);
                b++;
            } else {
                b++;
            }
        }
        for (int i = b; i < n; i++) {
            result.add(ma[b]);
        }

        return result;
    }

}
