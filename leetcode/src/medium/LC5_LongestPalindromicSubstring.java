package medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */

/**
 * @ClassName: LC5_LongestPalindromicSubstring
 * @Description: 最长回文子串
 * @Author: 余佳东
 * @Date: 2018-11-17 10:48
 * @Version: V1.0
 **/
public class LC5_LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(new LC5_LongestPalindromicSubstring().longestPalindrome("aaaaa"));
    }
    /**
     * @Description: 窗口法求最长回文子串, 不能用substring，因为会导致内存超出限制，是不停创造新的对象；112 ms， 已经战胜 34.42 % 的 java 提交记
     * @Param: [s]
     * @Return: java.lang.String
     */
    public String longestPalindrome(String s) {
        for (int i = s.length(); i >= 1; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                boolean result = true;
                int mid = i / 2;

                for (int k = 0; k < mid; k++) {
                    if(s.charAt(j + k) != s.charAt(i - k + j -1)) {
                        result = false;
                        break;
                    }
                }

                if(result) {
                    return s.substring(j, j + i);
                }
            }
        }

        return "";
    }

    /**
     * @Description: 判断是否是回文串
     * @Param: [s]
     * @Return: boolean
     */
    public boolean Palindromic(String s) {
        int m = s.length() / 2;
        for (int i = 0; i < m; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 -i)) {
                return false;
            }
        }
        return true;
    }
}
