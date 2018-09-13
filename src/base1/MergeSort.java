package base1;


public class MergeSort {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * T(N) = 2*T(N/2) + O(N)
     * 时间复杂度: O(N*logN)  空间复杂度O(N)
     */
    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        // (l+r)/2
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
