package medium;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

import java.util.Arrays;

/**
 * @ClassName: LC30_NextPermutation
 * @Description: 下一个排列
 * @Author: 余佳东
 * @Date: 2018-12-12 14:05
 * @Version: V1.0
 **/
public class LC30_NextPermutation {
    /**
     * @Description: 13 ms, 在Next Permutation的Java提交中击败了89.15% 的用户， 时间复杂度，为（n ^ 3 log n ~ n ^ 4）
     * @Param: [nums]
     * @Return: void
     */
    public void nextPermutation(int[] nums) {
        boolean maxPermutation = false;
        int len = nums.length;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j >= i + 1; j--) {
                if(nums[i] < nums[j]) {
                    maxPermutation = true;

                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;

                    Arrays.sort(nums, i + 1 , len);
                    return;
                }
            }
        }

        if(! maxPermutation) {
            int i = 0;
            int j = nums.length - 1;

            while (i <= j) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = tmp;
            }
        }
    }
    /**
     * @Description: 12 ms, 在Next Permutation的Java提交中击败了94.15% 的用户, 一次遍历找到应该交换的下标，再取反操作
     * @Param: [nums]
     * @Return: void
     */
    public void nextPermutationOffical(int[] nums) {
        boolean maxPermutation = false;
        int len = nums.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                maxPermutation = true;
                break;
            }
        }
        if(maxPermutation) {
            int j = len - 1;
            for (; j > i; j--) {
                if(nums[j] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }

            int k = i + 1;
            j = len - 1;

            while (k <= j) {
                int tmp = nums[k];
                nums[k++] = nums[j];
                nums[j--] = tmp;
            }

        } else {
            int k = 0;
            int j = nums.length - 1;

            while (k <= j) {
                int tmp = nums[k];
                nums[k++] = nums[j];
                nums[j--] = tmp;
            }
        }

    }
    /**
     * @Description: 打印数组
     * @Param: [nums]
     * @Return: void
     */

    public static void printArray(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public static void main(String[] args) {
        LC30_NextPermutation test = new LC30_NextPermutation();
        int[] nums = {2,3,1};
        test.nextPermutationOffical(nums);
        printArray(nums);
    }
}
