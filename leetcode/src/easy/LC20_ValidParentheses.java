package easy;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */

import java.util.Stack;

/**
 * @ClassName: LC20_ValidParentheses
 * @Description: ValidParentheses
 * @Author: 余佳东
 * @Date: 2018-12-01 16:40
 * @Version: V1.0
 **/
public class LC20_ValidParentheses {
    /**
     * @Description: 使用堆栈,  7 ms, 在Valid Parentheses的Java提交中击败了91.35% 的用户
     * @Param: [s]
     * @Return: boolean
     */
    public boolean isValid(String s) {
        int len = s.length();

        if(len == 0 && len % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char tmpChar = s.charAt(i);


            if(!stack.isEmpty() && (stack.peek().equals((char)(((int) tmpChar) - 1))
                    || stack.peek().equals((char)(((int) tmpChar) - 2)))) {
                stack.pop();
            } else {
                stack.push(tmpChar);
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((char)(((int) '(') + 1)  );
        System.out.println(new LC20_ValidParentheses().isValid("{[]}"));
    }
}
