package com.xiongrj.algorithm.sort;

import com.google.common.base.Stopwatch;

/**
 * @author 熊仁杰
 * @date 2020/5/24
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class Test {

    @org.junit.Test
    public void test() {
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        int arr[] = {1,2,3,4};
        for (int i = 0; i < 1000000; i++) {
            swap2(arr,1,2);
        }
        System.out.println(stopwatch.stop());
        stopwatch.reset();
        stopwatch.start();
        for (int i = 0; i < 1000000; i++) {
            swap(arr,1,2);
        }
        System.out.println(stopwatch.stop());

    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap2(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
    }
}
