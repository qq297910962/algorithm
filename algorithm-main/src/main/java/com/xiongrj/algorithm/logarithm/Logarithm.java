package com.xiongrj.algorithm.logarithm;

import java.util.function.Consumer;

/**
 * @author 熊仁杰
 * @date 2020/5/23
 * @description
 * @company 杭州勤淮科技有限公司
 */
public interface Logarithm {

      int[] generateRandomArray(int maxSize, int maxValue);

      void test(int testTime, int maxSize, int maxValue, Consumer<int[]> consumer);

 }
