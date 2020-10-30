package leetcode.editor.cn;
//给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 示例 1: 
//
// 输入: nums = [1, 5, 1, 1, 6, 4]
//输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6] 
//
// 示例 2: 
//
// 输入: nums = [1, 3, 2, 2, 3, 1]
//输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2] 
//
// 说明: 
//你可以假设所有输入都会得到有效的结果。 
//
// 进阶: 
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 排序 
// 👍 195 👎 0

import java.util.Arrays;

public class WiggleSortIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            int step = nums.length / 2;
            int count = step;
            if (nums.length % 2 == 1) {
                count++;
            }



            for (int i = 1, j = i+step; i <= count; i+=2, j+=2) {
                System.out.println("交换:" + i + " " + j);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new WiggleSortIi().new Solution();
//        int[] ints = {4, 3, 2, 1};
//        int[] ints = {1, 5, 1, 1, 6, 4};
        int[] ints = A.range(1, 7);
//        int[] ints = A.range(1, 8);
//        int[] ints = {4, 3, 2};
        s.wiggleSort(ints);
        A.p(ints);
    }
}