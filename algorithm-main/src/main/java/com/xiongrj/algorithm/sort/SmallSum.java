package com.xiongrj.algorithm.sort;

import java.util.Arrays;

/**
 * @author 熊仁杰
 * @date 2020/5/24
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class SmallSum {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int L, int R) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergeSort(arr, L, mid) +
                mergeSort(arr, mid + 1, R) +
                merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {
            sum += arr[p1] < arr[p2] ? (R - p2+1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = L; i < R + 1; i++) {
            arr[i] = help[i - L];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, -5, 2, 44, 64, 24};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }

}
