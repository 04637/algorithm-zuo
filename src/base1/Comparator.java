package base1;

import java.util.Arrays;

/**
 * 对数器
 */
public class Comparator {

    public static void main(String[] args) {
        int testTime = 50000;
        int length = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(length, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            Sort.insertSort(arr1);
            rightMethod(arr2);
            if(!Arrays.equals(arr1,arr2)){
                succeed = false;
                System.out.println("O: "+Arrays.toString(arr3));
                System.out.println("R: "+Arrays.toString(arr2));
                System.out.println("N: "+Arrays.toString(arr1));
                break;
            }
        }
        System.out.println(succeed?"Nice!":"Fuck!");
    }

    public static int[] generateRandomArray(int length, int value) {
        int[] arr = new int[(int) ((length + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }
}
