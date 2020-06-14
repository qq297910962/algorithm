package com.xiongrj.algorithm.leetcode;

import com.sun.org.apache.xerces.internal.xs.ShortList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 熊仁杰
 * @date 2020-06-12 10:46
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 电话号码的字母组合 {

    private final String letterMap[] = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private final List<String> list = new ArrayList<>();

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return list;
        }
        iterStr(digits, new StringBuilder(), 0);
        return this.list;
    }

    /**
     * @param digits
     * @param preChar 组合的前一个字符串
     * @param index
     */
    private void iterStr(String digits, StringBuilder preChar, int index) {
        //终止条件,下标已经超过最大下标,将字符串放入数组终止方法
        if (index >= digits.length()) {
            list.add(preChar.toString());
            return;
        }
        final char c = digits.charAt(index);
        final String str = letterMap[c - '0'];
        for (int i = 0; i < str.length(); i++) {
            StringBuilder newStr = new StringBuilder(preChar.toString());
            newStr.append(str.charAt(i));
            iterStr(digits, newStr, index + 1);
        }
    }


    /**
     * 队列解法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() < 1) {
            return list;
        }

        ArrayList<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            final char c = digits.charAt(i);
            final int index = c - '0';

            //index若为2  str="abc"
            final String str = letterMap[index];
            final int size = res.size();
            for (int j = 0; j < size; j++) {
                final String s = res.get(j);
                for (int k = 0; k < str.length(); k++) {
                    final String result = s + str.charAt(k);
                    res.add(result);
                }
            }
            for (int j = 0; j < size; j++) {
                res.remove(0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final 电话号码的字母组合 d = new 电话号码的字母组合();
        System.out.println(d.letterCombinations2("2"));

    }


}
