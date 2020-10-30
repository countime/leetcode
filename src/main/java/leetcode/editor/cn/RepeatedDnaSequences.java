package leetcode.editor.cn;
//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究
//非常有帮助。 
//
// 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例： 
//
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"] 
// Related Topics 位运算 哈希表 
// 👍 122 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequences{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> seen=new HashSet<>(),res=new HashSet<>();
        for (int i = 0; i < n - 10 + 1; i++) {
            String tmp = s.substring(i, i + 10);
            if (seen.contains(tmp)) {
                res.add(tmp);
            }
            seen.add(tmp);
        }

        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new RepeatedDnaSequences().new Solution();

        System.out.println('A'-'A');
        System.out.println('C'-'A');
        System.out.println('G'-'A');
        System.out.println('T'-'A');
    }
}