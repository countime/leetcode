package leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2637 👎 0

public class LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome2(String s) {
            if (s.length() < 2) {
                return s;
            }
            String res = s.substring(0, 1);
            for (int i = 0; i < s.length(); i++) {
                int l = i, r = i;
                // 一个字母为中心
                while (l > 0 && r + 1 < s.length() && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--;
                    r++;
                }
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }

                //两个字母为中心
                l = i + 1;
                r = i;
                while (l > 0 && r + 1 < s.length() && s.charAt(l-1) == s.charAt(r+1)) {
                    l--;
                    r++;
                }
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }
            }
            return res;
        }

        public String longestPalindrome(String s) {
            // 特判
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;

            // dp[i][j] 表示 s[i, j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            char[] charArray = s.toCharArray();

            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new LongestPalindromicSubstring().new Solution();
//        System.out.println(s.longestPalindrome("abaeabbae"));
//        System.out.println(s.longestPalindrome("abc"));
//        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("bb"));
    }
}