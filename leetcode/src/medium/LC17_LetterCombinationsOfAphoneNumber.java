package medium;

/**
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: LC17_LetterCombinationsOfAphoneNumber
 * @Description: 电话号码的字母组合
 * @Author: 余佳东
 * @Date: 2018-11-29 10:46
 * @Version: V1.0
 **/
public class LC17_LetterCombinationsOfAphoneNumber {
    /**
     * @Description:  字典法，回溯。3 ms, 在Letter Combinations of a Phone Number的Java提交中击败了84.59% 的用户
     * @Param: [digits]
     * @Return: java.util.List<java.lang.String>
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        System.out.println(result.size());

        if(digits == null || digits.length() == 0) {
            return result;
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        getAllList(result, map, 0,digits, new StringBuffer());
        return result;

    }

    /**
     * @Description: 递归得到所有情况
     * @Param: [result, map, count, digits, tmp]
     * @Return: void
     */
    public void getAllList(List<String> result, HashMap<Integer, String> map, int count, String digits,
                           StringBuffer tmp) {
        if(count >= digits.length()) {
            //System.out.println(tmp.toString());
            result.add(tmp.toString());
            return;
        }

        String strCount = map.get((int)(digits.charAt(count) - '0'));
        for (int i = 0, len = strCount.length(); i < len; i++) {
            tmp.append("" + strCount.charAt(i));
            getAllList(result, map, count + 1, digits, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC17_LetterCombinationsOfAphoneNumber().letterCombinations("").size());
    }

}
