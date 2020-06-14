package com.xiongrj.algorithm.leetcode;

/**
 * @author 熊仁杰
 * @date 2020-06-11 16:34
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 盛最多水的容器 {


    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        //利用双指针法,分别在左右两端
        //水的容量= 2个指针较小的长度 * 2个指针的距离
        //所以每次肯定移动较小的指针,因为移动的时候距离会变小,较小的指针长度变高才有可能使乘积变大
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, high * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


}
