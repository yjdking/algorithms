package medium;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */


/**
 * @ClassName: LC12_IntegerToRoman
 * @Description: 整数转罗马数字
 * @Author: 余佳东
 * @Date: 2018-11-23 15:34
 * @Version: V1.0
 **/
public class LC12_IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new LC12_IntegerToRoman().intToRoman(3));
    }

    /**
     * @Description:  递归算法，47 ms, 在Integer to Roman的Java提交中击败了98.99% 的用户
     * @Param: [num]
     * @Return: java.lang.String 
     */
    public String intToRoman(int num) {

        if(num < 10) {
            switch (num) {
                case (1) :
                    return "I";
                case (2) :
                    return "II";
                case (3) :
                    return "III";
                case (4) :
                    return "IV";
                case (5) :
                    return "V";
                case (6) :
                    return "VI";
                case (7) :
                    return "VII";
                case (8) :
                    return "VIII";
                case (9) :
                    return "IX";
                default:
                    return "";
            }
        } else if(num >= 1000) {
            return "M" + intToRoman(num - 1000);
        } else if(num >= 900) {
            return "CM" + intToRoman(num - 900);
        } else if(num >= 500) {
            return "D" + intToRoman(num - 500);
        } else if(num >= 400) {
            return "CD" + intToRoman(num - 400);
        } else if(num >= 100) {
            return "C" + intToRoman(num - 100);
        } else if(num >= 90) {
            return "XC" + intToRoman(num - 90);
        } else if(num >= 50) {
            return "L" + intToRoman(num - 50);
        } else if(num >= 40) {
            return "XL" + intToRoman(num - 40);
        } else if(num >= 10) {
            return "X" + intToRoman(num - 10);
        }

        return "";
    }
}
