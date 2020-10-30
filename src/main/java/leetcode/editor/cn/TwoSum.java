//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8959 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] indexs = new int[2];

            // 建立k-v ，一一对应的哈希表
            HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length; i++){
                if(hash.containsKey(target-nums[i])){
                    indexs[0] = i;
                    indexs[1] = hash.get(target-nums[i]);
                    return indexs;
                }
                // 将数据存入 key为补数 ，value为下标
                hash.put(nums[i],i);
            }
            return indexs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}