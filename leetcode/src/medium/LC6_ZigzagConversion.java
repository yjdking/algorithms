package medium;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 *
 *
 * 示例 2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 *
 * 解释:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */


/**
 * @ClassName: LC6_ZigzagConversion
 * @Description: Z字型变换
 * @Author: 余佳东
 * @Date: 2018-11-17 15:01
 * @Version: V1.0
 **/
public class LC6_ZigzagConversion {
    public static void main(String[] args){
        StringBuffer test = new StringBuffer('a' + "");
        String[] s = new String[2];
        String t = new String();
        s[0] = "" + s[0] + 's';
        System.out.println(s[0].equals(""));
        System.out.println(new LC6_ZigzagConversion().convert("asdfg", 5));

    }
    /**
     * @Description: 通过StringBuffer创建，遍历给定的字符串，判断每个Char在哪一行；38 ms, 已经战胜 90.43 % 的 java 提交记录
     * @Param: [s, numRows] 
     * @Return: java.lang.String 
     */
    public String convert(String s, int numRows) {
        if(numRows == 1 || s == null) {
            return s;
        }

        int len = s.length();
        StringBuffer[] result = new StringBuffer[numRows];
        result[0] = new StringBuffer("" + s.charAt(0));

        for (int i = 1; i < numRows; i++) {
            result[i] = new StringBuffer();
        }
        StringBuffer str2 = new StringBuffer();
        StringBuffer str3 = new StringBuffer();
        StringBuffer str4 = new StringBuffer();

        int j = 0;
        boolean odd;
        int a;
        for(int i = 1; i < len; i++) {
            char eneryChar = s.charAt(i);

            if(i % 3 == 0) {
                j = 0;
            }

            odd = ((i - 1) / (numRows - 1)) % 2 == 0 ? false : true;
            a = odd ? --j : ++j;

            result[a].append("" + eneryChar);
        }

        for (int i = 1; i < numRows; i++) {
            result[0].append(result[i]);
        }
        return result[0].toString();
    }

    /**
     * @Description: 通过String创建，97 ms, 已经战胜 25.55 % 的 java 提交记录
     * @Param: [s, numRows]
     * @Return: java.lang.String
     */
    public String convertString(String s, int numRows) {
        if(numRows == 1 || s == null) {
            return s;
        }

        int len = s.length();
        String[] result = new String[numRows];
        result[0] = "" + s.charAt(0);

        int j = 0;
        boolean odd;
        int a;
        for(int i = 1; i < len; i++) {
            char eneryChar = s.charAt(i);

            odd = ((i - 1) / (numRows - 1)) % 2 == 0 ? false : true;
            a = odd ? --j : ++j;
            result[a] = result[a] == null ? "" + eneryChar : result[a] + eneryChar;
        }

        for (int i = 1; i < numRows; i++) {
            if(result[i] == null) {
                result[i] = "";
            }
            result[0] += result[i];
        }
        return result[0].toString();
    }
}
