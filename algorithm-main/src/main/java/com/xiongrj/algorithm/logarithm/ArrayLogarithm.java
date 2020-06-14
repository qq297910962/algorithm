package com.xiongrj.algorithm.logarithm;

import java.util.function.Consumer;

/**
 * @author 熊仁杰
 * @date 2020/5/23
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class ArrayLogarithm extends AbstractLogarithm {

    public static void arrayTest( Consumer<int[]> consumer) {
        arrayTest(500000,100,100,consumer);
    }

    public static void arrayTest(int testTime, int maxSize, int maxValue, Consumer<int[]> consumer) {
        ArrayLogarithm arrayLogarithm = new ArrayLogarithm();
        arrayLogarithm.test(testTime,maxSize,maxValue,consumer);
    }

}
