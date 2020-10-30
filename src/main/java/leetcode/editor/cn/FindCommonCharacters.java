package leetcode.editor.cn;
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 103 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            int[] a0 = new int[26];
            for (char c : A[0].toCharArray()) {
                a0[c - 'a']++;
            }

            for (int i = 1; i < A.length; i++) {
                int[] tmp = new int[26];
                for (char c : A[i].toCharArray()) {
                    tmp[c-'a']++;
                }
                for (int j = 0; j < a0.length; j++) {
                    if (a0[j] > 0) {
                        a0[j] = Math.min(a0[j], tmp[j]);
                    }
                }
            }
            List<String> list=new ArrayList<>();
            for (int i = 0; i < a0.length; i++) {
                for (int j = 0; j < a0[i]; j++) {
                    list.add(new String(new char[]{(char) ('a' + i)}));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new FindCommonCharacters().new Solution();
    }
}