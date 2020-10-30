package leetcode.editor.cn;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 403 👎 0

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> r = new ArrayList<>(10);

        public List<String> restoreIpAddresses(String s) {
            process(0, "", s);
            return r;
        }

        private void process(int hCnt, String head, String tail) {
            int tCnt = 4 - hCnt;
            int tailLen = tail.length();
            if (tailLen < tCnt || tailLen > tCnt * 3) {
                return;
            }
            if (hCnt == 3) {
                if (valid(tail)) {
                    r.add(head + tail);
                }
                return;
            }
            String first = tail.substring(0, 1);
            process(hCnt + 1, head + first + ".", tail.substring(1));
            if (!tail.startsWith("0")) {
                if (tailLen > tCnt) {
                    process(hCnt + 1, head + tail.substring(0, 2) + ".", tail.substring(2));
                }
                if (tailLen > 1 + tCnt) {
                    String part3 = tail.substring(0, 3);
                    if (valid(part3)) {
                        process(hCnt + 1, head + part3 + ".", tail.substring(3));
                    }
                }
            }
        }

        private boolean valid(String s) {
            int length = s.length();
            if (length == 1) {
                return true;
            }
            if (s.startsWith("0")) {
                return false;
            }
            if (s.length() == 3) {
                return s.compareTo("256") < 0;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new RestoreIpAddresses().new Solution();
        System.out.println(s.restoreIpAddresses("1111"));
    }
}