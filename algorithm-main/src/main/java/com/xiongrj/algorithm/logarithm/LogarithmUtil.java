package com.xiongrj.algorithm.logarithm;

import lombok.experimental.UtilityClass;

import java.util.function.Consumer;

/**
 * @author 熊仁杰
 * @date 2020/5/23
 * @description
 * @company 杭州勤淮科技有限公司
 */
@UtilityClass
public class LogarithmUtil {


    public void arrayTest(int testTime, int maxSize, int maxValue, Consumer<int[]> consumer) {
        ArrayLogarithm arrayLogarithm = new ArrayLogarithm();
        arrayLogarithm.test(testTime,maxSize,maxValue,consumer);
    }
}
