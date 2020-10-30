package leetcode.editor.cn;
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 546 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        List<Integer>[] lists = new List[nums.length+1];
        count.forEach((key,v)->{
            if (lists[v] == null) {
                lists[v] = new ArrayList<>();
            }
            lists[v].add(key);
        });


        int[] result = new int[k];
        int x=0;

        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                for (Integer num : lists[i]) {
                    result[x++] = num;
                }
                if (x == k) {
                    break;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new TopKFrequentElements().new Solution();
        int[] res = s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}