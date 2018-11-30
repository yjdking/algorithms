package medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

/**
 * @ClassName: LC11_ContainerWithMostWater
 * @Description: 盛最多水的容器
 * @Author: 余佳东
 * @Date: 2018-11-22 14:33
 * @Version: V1.0
 **/
public class LC11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; //49
        int[] height1 = {2, 3, 10, 5, 7, 8, 9}; //36
        System.out.println(new LC11_ContainerWithMostWater().maxAreaTrue(height1));
    }

    /**
     * @Description: 动态规划，新的列为j，遍历（0-j）与J的Area，与之前的dp数组比较。O(n ^ 2); 451 ms, 击败了10.85% 的用户
     * @Param: [height]
     * @Return: int
     */
    public int maxArea(int[] height) {
        int[] dp = new int[height.length + 1];
        dp[2] = Math.min(height[0], height[1]);

        for (int i = 2, len = height.length; i < len; i++) {
            dp[i + 1] = dp[i];
            for (int j = 0; j < i; j++) {

                int tmpArea = Math.min(height[j], height[i]) * (i - j);
                if(tmpArea > dp[i + 1]) {
                    dp[i + 1] = tmpArea;
                }
            }
        }
        return dp[height.length];
    }

    /**
     * @Description: 官方解法，5 ms, 在Container With Most Water的Java提交中击败了99.85% 的用户
     * 使用一次扫描： 双指针各自往中间靠移动指向较短线段的指针尽管造成了矩形宽度的减小，
     * 但却可能会有助于面积的增大因为移动较短线段的指针会得到一条相对较长的线段，
     * 这可以克服由宽度减小而引起的面积减小；
     * @Param: [height]
     * @Return: int
     */
    public int maxAreaTrue(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        boolean lastPointer = false;

        while (j != i) {
            int tmpArea = Math.min(height[j], height[i]) * (j - i);
            if(tmpArea > maxArea) {
                maxArea = tmpArea;
            }

            // false 代表上一个指针动的是J，True代表上一个指针动的是i
            if(height[j] < height[i]) {
                j--;
                lastPointer = false;
            } else {
                i++;
                lastPointer = true;
            }
        }
        return maxArea;
    }
}
