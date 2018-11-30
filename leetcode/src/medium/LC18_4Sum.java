package medium;


/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: LC18_4Sum
 * @Description: 四数之和, 与三数和一样， 45 ms, 在4Sum的Java提交中击败了89.51% 的用户
 * @Author: 余佳东
 * @Date: 2018-11-30 16:12
 * @Version: V1.0
 **/
public class LC18_4Sum {
    HashMap<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i <= len - 4; i++) {

            if (nums[i] == -10) {
                System.out.println("sad");
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            for (int j = i + 1; j <= len - 3; j++) {
                int m = j + 1;
                int r = len - 1;

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                while (m < r) {
                    if (nums[i] + nums[j] + nums[m] + nums[r] > target) {
                        while (r > m && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    } else if (nums[i] + nums[j] + nums[m] + nums[r] < target) {
                        while (m < r && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;
                    } else {
                        boolean repeat = false;
                        if (map.containsKey(nums[i])) {
                            int index = map.get(nums[i]);
                            for (int k = index; k < result.size() && nums[j] >= result.get(k).get(1); k++) {
                                if (nums[j] == result.get(k).get(1) && nums[m] == result.get(k).get(2) && nums[r] ==
                                        result.get(k).get(3)) {
                                    repeat = true;
                                    break;
                                }
                            }
                        } else {
                            map.put(nums[i], result.size());
                        }

                        if (!repeat) {
                            result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[r])));
                            // System.out.println("result: " + result);
                        }

                        r--;
                        m++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {-4,0,-4,2,2,2,-2,-2};
        int[] nums = {4, -3, -8, 5, 2, 10, 6, 3, -4, -4, 4, 3, 0, -10, 0, -6, -5, -3};
        List<List<Integer>> r = new LC18_4Sum().fourSum(nums, -19);
        System.out.println("r: " + r);
    }
}
