package leetcode.editor.cn;
//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。） 
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。 
//
// 返回所有不常用单词的列表。 
//
// 您可以按任何顺序返回列表。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 200 
// 0 <= B.length <= 200 
// A 和 B 都只包含空格和小写字母。 
// 
// Related Topics 哈希表 
// 👍 67 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UncommonWordsFromTwoSentences {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : A.split(" ")) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            for (String w : B.split(" ")) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            List<String> list = new ArrayList<>(map.size());
            map.forEach((k,v)->{
                if (v == 1) {
                    list.add(k);
                }
            });
            return list.toArray(new String[list.size()]);
        }

        public String[] uncommonFromSentences2(String A, String B) {
            Set<String> s1 = oneSet(A);
            Set<String> s2 = oneSet(B);

            List<String> list = new ArrayList<>(s1.size()+s2.size());
            for (String s : s1) {
                if (!s2.contains(s)) {
                    list.add(s);
                }
            }
            for (String s : s2) {
                if (!s1.contains(s)) {
                    list.add(s);
                }
            }
            return list.toArray(new String[list.size()]);
        }

        private Set<String> oneSet(String s) {
            String[] split = s.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String w : split) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            Set<String> set=new HashSet<>();
            map.forEach((k,v)->{
                if (v == 1) {
                    set.add(k);
                }
            });

            return set;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new UncommonWordsFromTwoSentences().new Solution();
        String[] strings = s.uncommonFromSentences("s z z ext", "z a ext");
        A.p(strings);

    }
}