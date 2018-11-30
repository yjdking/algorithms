package easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */

/**
 * @ClassName: LC14_LongestCommonPrefix
 * @Description: 最长公共前缀
 * @Author: 余佳东
 * @Date: 2018-11-24 14:26
 * @Version: V1.0
 **/
public class LC14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] test = {"flower","flow","flight"};
        String[] test1 = {"dog","racecar","car"};
        String[] test2 = {"dog"};
        String[] test3 = {""};

     /*   System.out.println(test4.length);
        System.out.println(test4 == null);*/
        System.out.println(new LC14_LongestCommonPrefix().longestCommonPrefix(test3));
    }
    /**
     * @Description: 执行用时：9 ms， 已经战胜 83.67 % 的 java 提交记录，注意strs == []的情况
     * @Param: [strs]
     * @Return: java.lang.String
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        StringBuffer result = new StringBuffer();

        int i = 0;
        boolean prefixEquals = true;

        while (prefixEquals && i < minLen) {
            for (int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    prefixEquals = false;
                    break;
                }
            }

            if(prefixEquals) {
                result.append("" + strs[0].charAt(i));
            }
            i++;
        }

        return result.toString();
    }
}
