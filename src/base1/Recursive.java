package base1;

public class Recursive {

    public static void main(String[] args) {
        int[] arr = {1, 14, 7, 9, 10, 11, 3, 2, 7, 9, 1, 8, 3, 2, 7, 9, 10, 8, 10};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }


    /**
     * 样本量为N的时间复杂度T(N)  a为子任务发生次数  (N/b)为子过程的样本量  O(N^d)为除去子过程的时间复杂度
     * T(N) = aT(N/b) + O(N^d)
     * 符合上面通式 即子过程规模一样(只看代码写出来的过程, 不要展开分析子过程的子过程) 可使用 master公式  👇👇👇
     * log(b,a) > d -> 复杂度 O(N^log(b,a))
     * log(b,a) = d -> 复杂度 O(N^d*logN)
     * log(b,a) < d -> 复杂度 O(N^d)
     * 本算法 a=2, b=2, d=0 复杂度为 O(N)
     */
    public static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int lMax = getMax(arr, l, mid);
        int rMax = getMax(arr, mid + 1, r);
        return Math.max(lMax, rMax);
    }
}
