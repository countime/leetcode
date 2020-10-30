package leetcode.editor.cn;
//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 108 👎 0

public class KeyboardRow {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            int idx=0;
            out:
            for (String word : words) {
                char[] chars = word.toCharArray();
                for (int i = 1; i < chars.length; i++) {
                    if (getLine(chars[0]) != getLine(chars[i])) {
                        continue out;
                    }
                }
                words[idx++] = word;
            }
            String[] res = new String[idx];
            for (int i = 0; i < idx; i++) {
                res[i] = words[i];
            }
            return res;
        }

        private int getLine(char c) {
            if ("qwertyuiop".indexOf(Character.toLowerCase(c)) != -1) {
                return 1;
            } else if ("asdfghjkl".indexOf(Character.toLowerCase(c)) != -1) {
                return 2;
            } else if ("zxcvbnm".indexOf(Character.toLowerCase(c)) != -1) {
                return 3;
            }
            throw new RuntimeException("xx");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new KeyboardRow().new Solution();
        String[] words = s.findWords(new String[]{"abc", "aaa"});
        A.p(words);
    }
}