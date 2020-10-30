package leetcode.editor.cn;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 814 👎 0

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            List<StringBuilder> list=new ArrayList<>();
            for (int i = 0; i < Math.min(s.length(), numRows); i++) {
                list.add(new StringBuilder());
            }

            int row=0;
            boolean goDown = false;
            for (char c : s.toCharArray()) {
                if (row == 0 || row == numRows - 1) {
                    goDown=!goDown;
                }
                list.get(row).append(c);
                row += (goDown ? 1 : -1);
            }

            StringBuilder r=new StringBuilder();
            for (StringBuilder sb : list) {
                r.append(sb);
            }
            return r.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new ZigzagConversion().new Solution();
        String res = s.convert("LEETCODEISHIRING", 3);
//        String res = s.convert("AB", 1);
//        String res = s.convert("PAYPALISHIRING", 7);
        System.out.println(res);
    }
}