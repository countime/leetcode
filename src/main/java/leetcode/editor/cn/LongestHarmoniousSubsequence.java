package leetcode.editor.cn;
//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表 
// 👍 126 👎 0

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res=0;
        for (Integer integer : map.keySet()) {
            Integer next = map.get(integer + 1);
            if (next != null) {
                int tmp = map.get(integer) + next;
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new LongestHarmoniousSubsequence().new Solution();
    }
}