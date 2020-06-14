package com.xiongrj.algorithm.sort;

import com.xiongrj.algorithm.logarithm.ArrayLogarithm;

import java.util.Arrays;

/**
 * @author 熊仁杰
 * @date 2020/5/30
 * @description 堆排序
 * @company 杭州勤淮科技有限公司
 */
public class HeapSort {


    public static void sort(int[] arr) {

        //先构建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        //将大根堆根节点与最后一个节点交换 最后一个元素就是最大的值,
        // 然后继续在除了最后一个元素之前的下标中构建大根堆 以此类推达到排序

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapModify(arr, i);
        }

    }

    private static void heapModify(int[] arr, int heapSize) {
        int index = 0;
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            //获取左孩子和右孩子较大孩子的下标
            int largest = arr[leftIndex] < arr[leftIndex + 1] && ((leftIndex + 1) < heapSize)
                    ? leftIndex + 1 : leftIndex;
            //较大孩子比当前节点大,则交换,否则直接退出,
            // 因为在堆中孩子的孩子会更小
            if (arr[index] < arr[largest]) {
                swap(arr, index, largest);
            } else {
                break;
            }
            index = largest;
            leftIndex = index * 2 + 1;
        }

    }

    /**
     * 构建堆
     *
     * @param arr
     * @param i
     */
    private static void heapInsert(int[] arr, int i) {
        //堆中某个元素的的父节点下标为  (i-1)/2
        //堆中某个元素的子节点下标为 i*2+1 和 i*2+2
        int father = (i - 1) / 2;
        while (father >= 0 && arr[father] < arr[i]) {
            swap(arr, i, father);
            i = father;
            father = (i - 1) / 2;
        }
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{3, 3, -9, 8, 6};
//        sort(arr);
        ArrayLogarithm.arrayTest(HeapSort::sort);
    }
}
