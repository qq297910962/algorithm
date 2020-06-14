package com.xiongrj.algorithm.sort;

import com.xiongrj.algorithm.logarithm.ArrayLogarithm;

/**
 * @author 熊仁杰
 * @date 2020/5/31
 * @description 快排
 * @company 杭州勤淮科技有限公司
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //声明2个指针
            int low = L;
            int high = R;

            //将第一个数与随机一个数交换,则就是随机快排
            swap(arr,L, L + (int) (Math.random() * (R - L + 1)));

            //空索引的值就是基准数
            int emptyIndex = low;
            //基准数
            int benchmark = arr[emptyIndex];

            while (low < high) {

                while (arr[high] >= benchmark && low < high) {
                    high--;
                }
                if (low < high) {
                    //将小于基准数的值放到左边空位,并且空位转移到右边
                    arr[emptyIndex] = arr[emptyIndex = high];
                }
                while (arr[low] <= benchmark && low < high) {
                    low++;
                }
                if (low < high) {
                    //将大于基准数的值放到右边空位,并且空位转移到左边
                    arr[emptyIndex] = arr[emptyIndex = low];
                }
            }

            arr[emptyIndex] = benchmark;

            quickSort(arr, L, emptyIndex - 1);

            quickSort(arr, emptyIndex + 1, R);
        }


    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        ArrayLogarithm.arrayTest(QuickSort::sort);
    }

}
