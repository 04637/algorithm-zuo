package base2;

import base1.Comparator;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int testTime = 50000;
        int length = 8;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Comparator.generateRandomArray(length, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            try {
                quickSort(arr1);
                Arrays.sort(arr2);
                if (!Arrays.equals(arr1, arr2)) {
                    succeed = false;
                    System.out.println("O: " + Arrays.toString(arr3));
                    System.out.println("R: " + Arrays.toString(arr2));
                    System.out.println("N: " + Arrays.toString(arr1));
                    break;
                }
            } catch (StackOverflowError e) {
                System.out.println("O: " + Arrays.toString(arr3));
            }
        }
        System.out.println(succeed ? "Nice!" : "Fuck!");
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }


    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
