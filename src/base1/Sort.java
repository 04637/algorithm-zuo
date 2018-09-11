package base1;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        Random rand = new Random();
        int len = 15;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     * 时间复杂度: O(N^2)
     */
    public static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i-1;j>=0&&a[j]>a[j+1];j--){
                swap(a, j, j+1);
            }
        }
    }


    /**
     * 冒泡排序
     * 时间复杂度: O(N^2)
     */
    public static void bubbleSort(int[] a) {

        for (int end = a.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                }
            }
        }

    }

    /**
     * 选择排序
     * 时间复杂度: O(N^2)
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                minIndex = a[j] < a[minIndex] ? j : minIndex;
            }
            swap(a, i, minIndex);
        }
    }


    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
