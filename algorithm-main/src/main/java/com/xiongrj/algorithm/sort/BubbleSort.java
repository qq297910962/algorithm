package com.xiongrj.algorithm.sort;

import com.xiongrj.algorithm.logarithm.ArrayLogarithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author 熊仁杰
 * @date 2020/5/16
 * @description 冒泡排序
 * @company 杭州勤淮科技有限公司
 */
public class BubbleSort {

    public static void sort(int[] ary) {
        if (ary == null || ary.length < 2) {
            return;
        }

        for (int i = 0; i < ary.length - 1; i++) {
            for (int j = 0; j < ary.length - 1 - i; j++) {
                if (ary[j] > ary[j + 1]) {
                    int temp = ary[j];
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayLogarithm.arrayTest(BubbleSort::sort);

    }


}
