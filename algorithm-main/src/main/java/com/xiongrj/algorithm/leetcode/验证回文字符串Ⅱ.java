package com.xiongrj.algorithm.leetcode;

/**
 * @author 熊仁杰
 * @date 2020-06-12 16:28
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 验证回文字符串Ⅱ {

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     *
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * 注意:
     *
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            char c = s.charAt(a);
            char c1 = s.charAt(b);
            if (c != c1) {
                return isPalindrome(s, ++a, b) || isPalindrome(s, --a, --b);
            }
            a++;
            b--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int a, int b) {
        while (a <= b) {
            char c = s.charAt(a);
            char c1 = s.charAt(b);
            if (c != c1) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abaa"));
    }


}
