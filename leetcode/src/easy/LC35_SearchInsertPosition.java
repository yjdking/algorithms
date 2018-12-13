package easy;
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
/**
 * @ClassName: LC35_SearchInsertPosition
 * @Description: 搜索插入位置
 * @Author: 余佳东
 * @Date: 2018-12-13 17:14
 * @Version: V1.0
 **/
public class LC35_SearchInsertPosition {
    /**
     * @Description:  3 ms, 在Search Insert Position的Java提交中击败了100.00% 的用户;
     * @Param: [nums, target] 
     * @Return: int 
     */
    public int searchInsert(int[] nums, int target) {
        int result = serchTarget(nums, target, 0, nums.length - 1);

        return result;
    }
    /**
     * @Description: 二分查找
     * @Param: [nums, target, low, high]
     * @Return: int
     */
    private int serchTarget(int[] nums, int target, int low, int high) {
        if (low >= high) {
            if (nums[low] == target) {
                return low;
            } else if (nums[low] > target) {
                return low;
            } else if (nums[high] < target) {
                return high + 1;
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
        return 0;
    }
    public static void main(String[] args) {
        LC35_SearchInsertPosition test = new LC35_SearchInsertPosition();
        int[] nums = {1,3};
        System.out.println(test.searchInsert(nums, 0));
    }
}
