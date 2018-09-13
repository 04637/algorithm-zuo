package base2;

import base1.Comparator;

import java.util.Arrays;

/**
 * Dutch national flag problem
 * wiki: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr1 = Comparator.generateRandomArray(10, 10);
        //int[] arr1 = {3, 2, -5, 0, 0, 1, 2, 4, 6, -3};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        partition(arr1, 4);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] partition(int[] arr, int num) {
        int l = -1;
        int r = arr.length;
        for (int i = 0; i < r; i++) {
            if (arr[i] > num) {
                swap(arr, i--, --r);
            } else if (arr[i] < num) {
                swap(arr, i, ++l);
            }
        }
        return new int[]{l + 1, r - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
