package medium;
/**
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

/**
 * @ClassName: LC34_FindFirstAndLastPositionOfElementInSortedArray
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * @Author: 余佳东
 * @Date: 2018-12-13 10:37
 * @Version: V1.0
 **/
public class LC34_FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * @Description: 前后指针法. 6 ms, 在Find First and Last Position of Element in Sorted Array的Java提交中击败了85.16% 的用户
     * @Param: [nums, target]
     * @Return: int[]
     */
    public int[] searchRangeMy(int[] nums, int target) {
        int[] result = new int[2];

        int i = 0;
        int j = nums.length - 1;
        boolean startIndex = false;
        boolean endIndex = false;

        while (j >= i && !(startIndex && endIndex)) {
            if (!startIndex) {
                if (nums[i] < target) {
                    i++;
                } else if (nums[i] > target) {
                    return new int[]{-1, -1};
                } else {
                    startIndex = true;
                }
            }

            if (!endIndex) {
                if (nums[j] > target) {
                    j--;
                } else if (nums[j] < target) {
                    return new int[]{-1, -1};
                } else {
                    endIndex = true;
                }
            }
        }

        if (!(startIndex && endIndex)) {
            return new int[]{-1, -1};
        } else {
            return new int[]{i, j};
        }
    }


    /**
     * @Description: 二分查找加前后指针,  8 ms, 在Find First and Last Position of Element in Sorted Array的Java提交中击败了41.89% 的
     * @Param: [nums, target]
     * @Return: int[]
     */
    public int[] searchRange(int[] nums, int target) {
        int mid = serchTarget(nums, target, 0 , nums.length - 1);

        if(mid == -1) {
            return new int[]{-1, -1};
        }
        System.out.println("mid: " + mid);
        int start = mid;
        int end = mid;


        while (start >= 0) {
            if (nums[start] == target) {
                start--;
            } else {
                break;
            }
        }

        while (end <= nums.length - 1) {
            if (nums[end] == target) {
                end++;
            } else {
                break;
            }
        }

        return new int[]{start + 1, end - 1};
    }

    /**
     * @Description: 二分查找
     * @Param: [nums, target, low, high]
     * @Return: int
     */
    private int serchTarget(int[] nums, int target, int low, int high) {
        if (low == high) {
            if (nums[low] == target) {
                return low;
            } else {
                return -1;
            }
        } else if(low > high) {
            return  -1;
        } else {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return serchTarget(nums, target, low, mid - 1);
            } else {
                return serchTarget(nums, target, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        LC34_FindFirstAndLastPositionOfElementInSortedArray test =
                new LC34_FindFirstAndLastPositionOfElementInSortedArray();
        // int[] nums = {5};
        int[] nums = {5,7,7,8,8,10};
        // int[] nums = {2,2};
        int[] result = test.searchRange(nums, 8);
        System.out.println(result[0] + "," + result[1]);
    }
}
