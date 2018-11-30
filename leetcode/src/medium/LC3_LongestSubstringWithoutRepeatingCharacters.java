package medium;

/**输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 *
 * 输入 "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */

import java.util.Scanner;

/**
 * @ClassName: LC3_LongestSubstringWithoutRepeatingCharacters
 * @Description: 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * @Author: 余佳东
 * @Date: 2018-11-16 21:24
 * @Version: V1.0
 **/
public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            System.out.println(lengthOfLongestSubstring(str));
        }
    }
    /**
     * @Description: 使用动态规划；状态转移方程：当前的char型往前,直到没有重复, 时间复杂度为O(n^3)
     * @Param: [s]
     * @Return: int
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            
            int j = 1;
            boolean du = false;
            for (int k = i - 1; k >= 0 && !du; k--) {
                if(s.substring(k + 1, i + 1).contains(s.charAt(k) + "")) {
                    // System.out.print("i: " + i + "k :" + k);
                    // System.out.println( " " + s.substring(k + 1, i + 1));
                    break;
                } else {
                    j++;
                }
                /*for (int l = i; l >= k + 1 ; l--) {
                    if(s.charAt(l) == s.charAt(k)) {
                        du = true;
                        break;
                    }
                }

                if(!du) {
                    j++;
                }*/
            }

            dp[i + 1] = Math.max(dp[i], j);
        }
        return  dp[s.length()];
    }
}
