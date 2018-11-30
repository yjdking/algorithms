package easy;

/**
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 *示例 1:
 *
 *输入: 121
 *输出: true
 *示例 2:
 *
 *输入: -121
 *输出: false
 *解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *示例 3:
 *
 *输入: 10
 *输出: false
 *解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */

/**
 * @ClassName: LC9_PalindromeNumber
 * @Description: 回文数
 * @Author: 余佳东
 * @Date: 2018-11-22 09:52
 * @Version: V1.0
 **/
public class LC9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new LC9_PalindromeNumber().LC9_PalindromeNumber(121));
    }
    /**
     * @Description: 把整数转化为字符串比较, 148 ms, 已经战胜 84.14 % 的 java 提交记录
     * @Param: [x]
     * @Return: boolean
     */
    public boolean LC9_PalindromeNumber(int x) {
        String xString = "" + x;

        for (int i = 0, len = xString.length() / 2; i < len; i++) {
            if(xString.charAt(i) == xString.charAt(xString.length() - i - 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
