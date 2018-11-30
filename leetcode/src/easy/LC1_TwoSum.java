package easy;
/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName LC1_TwoSum
 * @Description: Leetcode1_两数之和
 * @Author: 余佳东
 * @Date: 2018-11-15 16:18
 * @Version V1.0
 **/
public class LC1_TwoSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
            int target = input.nextInt();
            printArrag(new LC1_TwoSum().OfficiaSolution(nums, target));
        }
    }
    /**
    　* @Description: 自己的题解时间复杂度：O(n^2) O(n)
    　* @Param: [nums, target]
    　* @Return: int[]
      */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == tmp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * @Description: 
     * @Param: [result] 
     * @Return: void 
     */
    public static void printArrag(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * @Description: 官方解法 O(n) O(n)
     * @Param: [nums, target]
     * @Return: int[]
     * @test [3, 3] [3, 2, 4]
     */
    public int[] OfficiaSolution(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i], i);
        }
        // System.out.println(mapNums.get(4));
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(mapNums.containsKey(tmp) && i != mapNums.get(tmp)) {
                result[0] = i;
                result[1] = mapNums.get(tmp);
                return  result;
            }
        }
        return result;
    }
}
