package medium;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LC22_GenerateParentheses
 * @Description: 括号生成, 回溯法， 3 ms, 在Generate Parentheses的Java提交中击败了81.57% 的用户
 * @Author: 余佳东
 * @Date: 2018-12-05 10:25
 * @Version: V1.0
 **/
public class LC22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, 0, 0, n, new StringBuffer());


        return result;
    }

    /**
     * @Description: 回溯法
     * @Param: [result, left, right, max, str]
     * @Return: void
     */
    public void generateParenthesis(List<String> result, int left, int right, int max, StringBuffer str) {
        if(left + right == 2 * max) {
            System.out.println("result: " + result.toString());
            result.add(str.toString());
            return;
        }

        if(left < max) {
            str.append("(");
            generateParenthesis(result, left + 1, right, max, str);
            str.deleteCharAt(str.length() - 1);
        }

        if(left > right) {
            str.append(")");
            generateParenthesis(result, left, right + 1, max, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new LC22_GenerateParentheses().generateParenthesis(3);
        System.out.println("list: " + list);
    }
}
