package easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */


import java.util.Stack;

/**
 * @ClassName: LC7_ReverseInteger
 * @Description: 整数反转
 * @Author: 余佳东
 * @Date: 2018-11-21 09:23
 * @Version: V1.0
 **/
public class LC7_ReverseInteger {
    public static void main(String[] args){
        System.out.println(-2147483648 < 0);

        System.out.println(new LC7_ReverseInteger().reverse(-2147483648));

    }
    /**
     * @Description: 两点：x 反转后可能大于int，返回0；x为负变为正之后也可能大于int；：64 ms， 已经战胜 13.91 % 的 java 提交记录
     * @Param: [x]
     * @Return: int
     */
    public int reverse(int x) {
        Long lx = (long)x;
        boolean negative = false;

        if(lx == 0) {
            return 0;
        } else if(lx < 0) {
            System.out.println(lx);
            negative = true;
            lx = Math.abs(lx);
        }
        Stack<Integer> stack = new Stack<>();

        while (lx != 0) {
            stack.push((int)(lx % 10));
            lx = lx / 10;
        }

        String ReverseString = "";
        while (!stack.isEmpty()) {
            ReverseString = stack.pop() + ReverseString;
        }

        long tmp = Long.parseLong(ReverseString);

        if(tmp >= Integer.MAX_VALUE || tmp <= Integer.MIN_VALUE) {
            return 0;
        }

        if(negative) {
            return -(int)tmp;
        }
        return (int)tmp;

    }
}
