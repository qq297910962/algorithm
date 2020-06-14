package com.xiongrj.algorithm.logarithm;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author 熊仁杰
 * @date 2020/5/23
 * @description
 * @company 杭州勤淮科技有限公司
 */
public abstract class AbstractLogarithm implements Logarithm {


    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void test(int testTime, int maxSize, int maxValue, Consumer<int[]> consumer) {
        boolean succeed = true;
        int[] sourceArr = null;
        int[] wrongArr = null;
        int[] righArr = null;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            sourceArr = copyArray(arr1);
            consumer.accept(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                wrongArr = arr1;
                righArr = arr2;
                break;
            }
        }
        if (succeed) {
            System.out.println("Nice!");
        } else {
            System.out.println("Fucking fucked!");
            System.out.println("Source Arr: " + Arrays.toString(sourceArr));
            System.out.println("Right Sort Arr: " + Arrays.toString(righArr));
            System.out.println("Wrong Sort Arr: " + Arrays.toString(wrongArr));
        }

    }
}
