package medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */

/**
 * @ClassName: LC33_SearchInRotatedSortedArray
 * @Description: 搜索旋转排序数组 8 ms, 在Search in Rotated Sorted Array的Java提交中击败了96.81% 的用户。
 *                  二分查找，一个判断是否升序，另一个直接查找
 * @Author: 余佳东
 * @Date: 2018-12-12 16:22
 * @Version: V1.0
 **/

public class LC33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // int mid
        while (high > low) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] < nums[high]) {
                int result = serchTarget(nums, target, low, high);
                return result;
            }

            if (nums[high] < nums[mid]) {
                int result = serchTarget(nums, target, low, mid - 1);

                if (result != -1) {
                    return result;
                }

                low = mid + 1;

                continue;
            } else if(nums[low] > nums[mid]){
                int result = serchTarget(nums, target, mid + 1, high);

                if (result != -1) {
                    return result;
                }

                high = mid - 1;
            }
        }

        if (high == low && nums[low] == target) {
            return low;
        }
        return -1;
    }

    /**
     * @Description: 二分查找
     * @Param: [nums, target, low, high]
     * @Return: int
     */
    public int serchTarget(int[] nums, int target, int low, int high) {
        if (low >= high) {
            if (nums[low] == target) {
                return low;
            } else {
                return -1;
            }
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
        LC33_SearchInRotatedSortedArray test = new LC33_SearchInRotatedSortedArray();
        // int[] nums = {3,5,1};
        int[] nums = {3,5,1};
        System.out.println(test.search(nums, 3));
    }
}
