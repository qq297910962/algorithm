package com.xiongrj.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author 熊仁杰
 * @date 2020-06-11 13:22
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 无重复字符的最长子串 {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //利用双指针,开始p1和p2都指向第一个字符,然后p2逐步往后移,每次key为字符,value为下标放入map中
        //每次刷新max的值
        //p2移的过程中如果从map中获取了下标,则说明重复,如果map中的下标大于当前p1下标则把p1移位
        HashMap<Character, Integer> map = new HashMap(s.length());
        int max = 1;
        int p1 = 0;
        int p2 = 0;
        while (p2 < s.length()) {
            final char c = s.charAt(p2);
            final Integer index = map.get(c);
            if (index != null) {
                p1 = (index + 1) > p1 ? index + 1 : p1;
            }
            max = Math.max(max, p2 - p1 + 1);
            map.put(c, p2++);
        }
        return max;
    }


    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
