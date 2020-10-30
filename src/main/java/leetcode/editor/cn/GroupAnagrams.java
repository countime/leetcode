package leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 488 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ca = new char[26];
                for (char c : s.toCharArray())
                    ca[c - 'a']++;
                String keyStr = String.valueOf(ca);
                if (!map.containsKey(keyStr))
                    map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }


        public List<List<String>> groupAnagrams2(String[] strs) {
            Map<String, List> ans = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new GroupAnagrams().new Solution();
    }
}