package com.xiongrj.algorithm.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 熊仁杰
 * @date 2020-06-10 17:55
 * @description
 * @company 杭州勤淮科技有限公司
 */
public class 两数之和 {

    /**
     * https://leetcode-cn.com/problems/two-sum/submissions/
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};

    }


    /**
     * 利用hashMap,存下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //计算需要的另一个数
            final int needNum = target - nums[i];
            //从map中查询,如果有则直接返回下标
            final Integer index = map.get(needNum);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("error param");
    }

}
