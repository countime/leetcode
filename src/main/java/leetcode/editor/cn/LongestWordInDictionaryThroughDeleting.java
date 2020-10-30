package leetcode.editor.cn;
//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 103 👎 0

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            d.sort((s1, s2) -> s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2));
            for (int i = 0; i < d.size(); i++) {
                String b = d.get(i);
                if (b.length() > s.length()) {
                    continue;
                }
                int y = 0;
                for (int x = 0; x < s.length() && y < b.length(); x++) {
                    if (s.charAt(x) == b.charAt(y)) {
                        y++;
                    }
                }

                if (y == b.length()) {
                    return b;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new LongestWordInDictionaryThroughDeleting().new Solution();

        String longestWord = s.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
        System.out.println(longestWord);
    }
}