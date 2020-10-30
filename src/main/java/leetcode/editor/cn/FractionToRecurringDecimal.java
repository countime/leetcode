package leetcode.editor.cn;
//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 示例 1: 
//
// 输入: numerator = 1, denominator = 2
//输出: "0.5"
// 
//
// 示例 2: 
//
// 输入: numerator = 2, denominator = 1
//输出: "2" 
//
// 示例 3: 
//
// 输入: numerator = 2, denominator = 3
//输出: "0.(6)"
// 
// Related Topics 哈希表 数学 
// 👍 174 👎 0

import java.util.HashMap;

public class FractionToRecurringDecimal {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            // 余数和产生余数的小数位
            HashMap<Long, Integer> map = new HashMap<>();

            long lnum=numerator;
            long lden = denominator;
            boolean positive = lnum * lden >= 0;
            lnum = lnum > 0 ? lnum : -lnum;
            lden = lden > 0 ? lden : -lden;

            long a = lnum / lden;
            long p = lnum % lden;
            if (p == 0) {
                return (positive ? "" : "-") +a + "";
            }

            int idx = 0;
            map.put(p, idx++);

            String r1 = a + ".";
            String r2 = "";
            long b = 10* p;
            while (true) {
                long i = b / lden;
                b = b % lden;
                if (b == 0) {
                    r2 = r2 + i;
                    break;
                } else if (map.containsKey(b)) {
                    Integer start = map.get(b);
                    r2 = r2 + i;
                    System.out.println("开始位置:" + start);
                    System.out.println(r2);
                    r2 = r2.substring(0, start) + "(" + r2.substring(start) + ")";
                    break;
                }
                r2 = r2 + i;
                System.out.println(r2);
                map.put(b, idx++);
                b = b * 10;
            }

            return (positive ? "" : "-") + r1 + r2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new FractionToRecurringDecimal().new Solution();
//        System.out.println(s.fractionToDecimal(1, 7));
//        System.out.println(s.fractionToDecimal(2, 1));
//        System.out.println(s.fractionToDecimal(4, 333)); //0.(012)
//        System.out.println(s.fractionToDecimal(1, 6));
        System.out.println(s.fractionToDecimal(-2147483648, 1));
    }
}