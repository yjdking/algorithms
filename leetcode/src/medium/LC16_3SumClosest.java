package medium;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */

import java.util.Arrays;

/**
 * @ClassName: LC16_3SumClosest
 * @Description: 最接近的三数之和
 * @Author: 余佳东
 * @Date: 2018-11-29 09:46
 * @Version: V1.0
 **/
public class LC16_3SumClosest {
    /**
     * @Description:  219 ms, 在3Sum Closest的Java提交中击败了3.79% 的用户,递归经典解法
     * @Param: [nums, target]
     * @Return: int
     */
    public int threeSumClosest(int[] nums, int target) {
        int[] differ = new int[1];
        differ[0] = Integer.MAX_VALUE;
        int[] mixSum = new int[1];

        getAllSum(nums, differ, mixSum, 0, target, 0, 0);
        return mixSum[0];
    }

    /**
     * @Description: 递归函数
     * @Param: [nums, differ, mixSum, sum, target, begin, count]
     * @Return: void
     */
    public void getAllSum(int[] nums, int[] differ, int[] mixSum, int sum, int target, int begin, int count) {
        if(count >= 3) {
            //System.out.println("sum: " + sum);
            if(Math.abs(sum - target) < differ[0]) {
                mixSum[0] = sum;
                differ[0] = Math.abs(sum - target);
            }
            return;
        }

        for (int i = begin, len = nums.length; i < len; i++) {
            getAllSum(nums, differ, mixSum, sum + nums[i], target, i + 1, count + 1);
        }
    }

    /**
     * @Description: 改进解法, 双指针, 27 ms, 在3Sum Closest的Java提交中击败了53.83% 的用户
     * @Param: [nums, target]
     * @Return: int
     */
    public int threeSumClosestOffical(int[] nums, int target) {
        Arrays.sort(nums);
        int sumMin = nums[0] + nums[1] + nums[2];
        int differ = Integer.MAX_VALUE;

        for (int i = 0, len = nums.length; i < len; i++) {
            int m = i + 1;
            int r = nums.length - 1;

            while (r > m && m > i) {

                int sum = nums[i] + nums[m] + nums[r];
                if(sum > target) {
                    if(Math.abs(sum - target) < differ) {
                        sumMin = sum;
                        differ = Math.abs(sum - target);
                    }

                    r--;
                } else if(sum < target) {
                    if(Math.abs(sum - target) < differ) {
                        sumMin = sum;
                        differ = Math.abs(sum - target);
                    }
                    m++;
                } else {
                    return sum;
                }
            }
        }
        return sumMin;
    }

    public static void main(String[] args) {
        int[] nums =  {1 ,1,1,0};
        System.out.print(new LC16_3SumClosest().threeSumClosestOffical(nums, -100));
    }
}
