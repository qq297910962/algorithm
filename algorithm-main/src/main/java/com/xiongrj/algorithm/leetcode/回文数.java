package com.xiongrj.algorithm.leetcode;

/**
 * @author 熊仁杰
 * @date 2020-06-10 16:33
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 回文数 {


    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        final char[] array = str.toCharArray();
        char[] reverseArray = new char[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[i] = array[array.length - 1 - i];
        }
        String reverseStr = new String(reverseArray);
        if (str.equals(reverseStr)) {
            return true;
        }
        return false;
    }


    public static boolean isPalindrome2(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        //12345-> 提取出543 和123对比  原始数每次要/10,如果原始数小于或者等于反转数,则说明已经到了一半
        int reverseNumber = 0;
        while (x > reverseNumber) {
            final int i = x % 10;
            reverseNumber = reverseNumber * 10 + i;
            x = x / 10;
        }
        return x == reverseNumber || (x * 10 + (reverseNumber % 10)) == reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(125211));
    }


}
