package base1;

import java.util.Arrays;

public class SmallSum {

    public static void main(String[] args) {
        int testTime = 50000;
        int length = 5;
        int value = 5;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            //int[] arr1 = Comparator.generateRandomArray(length, value);
            int[] arr1 = {3, 1, 1, 2};
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            try {
                int sum1 = smallSum(arr1);
                int sum2 = rightMethod(arr2);
                if (sum1!=sum2) {
                    succeed = false;
                    System.out.println("O: " + Arrays.toString(arr3));
                    System.out.println("R: " + sum2);
                    System.out.println("N: " + sum1);
                    break;
                }
            }catch (StackOverflowError e){
                System.out.println("O: " + Arrays.toString(arr3));
            }
        }
        System.out.println(succeed?"Nice!":"Fuck!");
    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // l+(r-l)/2  why?-> https://stackoverflow.com/questions/25113506/why-m-l-r-l-2-instead-of-m-lr-2-avoid-overflow-in-c
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return res;
    }

    public static int rightMethod(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

}
