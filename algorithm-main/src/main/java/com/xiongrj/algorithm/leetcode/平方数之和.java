package com.xiongrj.algorithm.leetcode;

/**
 * @author 熊仁杰
 * @date 2020-06-12 16:09
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 平方数之和 {


    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     *
     * 示例1:
     *
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     *  
     *
     * 示例2:
     *
     * 输入: 3
     * 输出: False
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int a = 0;
        //可以防止溢出
        int b = (int) Math.sqrt(c);

        while (a <= b) {
            final int res = a * a + b * b;
            if (res > c) {
                b--;
            } else if (res < c) {
                a++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(999999999));
    }

}
