package com.xiongrj.algorithm.sort;

import com.xiongrj.algorithm.logarithm.ArrayLogarithm;

import java.util.Arrays;

/**
 * @author 熊仁杰
 * @date 2020/5/24
 * @description 归并排序
 * @company 杭州勤淮科技有限公司
 */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 剖析递归行为和递归行为时间复杂度的估算 一个递归行为的例子
     * master公式的使用 T(N) = a*T(N/b) + O(N^d) 1)
     * log(b,a) > d -> 复杂度为O(N^log(b,a)) 2)
     * log(b,a) = d -> 复杂度为O(N^d * logN) 3)
     * log(b,a) < d -> 复杂度为O(N^d)
     * 补充阅读：www.gocalf.com/blog/algorithm-complexity-and-master- theorem.html
     * @param arr
     * @param L
     * @param R
     */
    private static void mergeSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //等同于 (L+R)/2  这样写防止L+R值溢出 并且性能快
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        /**
         * L~mid为有序 mid+1~R也为有序, 将2个有序的部分组装成一个有序的部分,
         * 用help数组保存,然后拷贝回原arr数组,比较2个指针数大小,每次小的那一方指针++
         * 最后指针后面还剩余元素的那一部分将元素拷贝到help的后面
         * help数组是一个合并2个有序部分的整体有序的数组
         */

        //p1指针指向左边有序部分的第一个数, p2指针指向右边数组的第一个数
        while (p1 <= mid && p2 <= R) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        //将help数组拷贝回arr
        for (int i = L; i < R + 1; i++) {
            arr[i] = help[i - L];
        }
    }

    public static void main(String[] args) {
        ArrayLogarithm.arrayTest(MergeSort::sort);
    }

}
