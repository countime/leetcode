package leetcode.editor.cn;
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 392 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] c2 = new char[26];

    public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res= new ArrayList<>();

        String target = getKey(p.toCharArray(), 0, p.length());

        char[] from = s.toCharArray();
        for (int i = 0; i < s.length() - p.length()+1; i++) {
            if (getKey(from, i, i + p.length()).equals(target)) {
                res.add(i);
            }
        }
        return res;
    }

    private String getKey(char[] chars,int start,int end){
        if (start == 0) {
            Arrays.fill(c2, (char)0);
            for (int i = start; i < end; i++) {
                c2[chars[i] - 'a']++;
            }
        } else {
            c2[chars[start-1] - 'a']--;
            c2[chars[end-1] - 'a']++;
        }
        return String.valueOf(c2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new FindAllAnagramsInAString().new Solution();
    }
}