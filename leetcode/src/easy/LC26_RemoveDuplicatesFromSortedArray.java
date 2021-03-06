package easy;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你
 * 必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4], 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢? 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者
 * 是可见的。你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 */

/**
 * @ClassName: LC26_RemoveDuplicatesFromSortedArray
 * @Description: 删除排序数组中的重复项, 91 ms, 在Remove Duplicates from Sorted Array的Java提交中击败了9.09% 的用户
 * @Author: 余佳东
 * @Date: 2018-12-06 10:40
 * @Version: V1.0
 **/
public class LC26_RemoveDuplicatesFromSortedArray {
    /**
     * @Description: 两次遍历， 一次遍历找重, 一次遍历位移， 时间复杂度为O(n ^ 2)；
     * @Param: [nums]
     * @Return: int 
     */
    public int removeDuplicates(int[] nums) {
        int length = 0;
        int i = 0;
        int len =  nums.length - 1;

        for (i = 0; i < len; i++) {
            if(nums[i] == nums[i + 1]) {
                length++;
                for (int j = i + 1; j < len; j++) {
                    nums[j] = nums[j + 1];
                }

                if (nums[i] == nums[i + 1]) {
                    i--;
                }
                len--;
            }
        }

        return nums.length - length;
    }

    /**
     * @Description: 双指针法。时间复杂度为O(n), 14 ms, 在Remove Duplicates from Sorted Array的Java提交中击败了69.22% 的用户
     * @Param: [nums]
     * @Return: int
     */
    public int removeDuplicatesTrue(int[] nums) {
        int slow = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[slow]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;
    }
    /**
     * @Description: asd
     * @Param: [args] 
     * @Return: void
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int[] n = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(new LC26_RemoveDuplicatesFromSortedArray().removeDuplicates(nums) + "asda");

        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
}
