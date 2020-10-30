package leetcode.editor.cn;
//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重
//复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,2,4]
//输出: [2,3]
// 
//
// 注意: 
//
// 
// 给定数组的长度范围是 [2, 10000]。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 126 👎 0

public class SetMismatch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            return findErrorNums2(nums);
        }

        public int[] findErrorNums1(int[] nums) {
            int total = 0;
            int[] map = new int[nums.length + 1];
            int dup = 0;
            for (int num : nums) {
                total += num;
                if (map[num] == 1) {
                    dup = num;
                }
                map[num] = 1;
            }

            int less = nums.length * (1 + nums.length) / 2 - total + dup;
            return new int[]{dup, less};
        }

        public int[] findErrorNums2(int[] nums) {
            int xor = 0, xor0 = 0, xor1 = 0;
            for (int n : nums)
                xor ^= n;
            for (int i = 1; i <= nums.length; i++)
                xor ^= i;
            int rightmostbit = xor & ~(xor - 1);
            for (int n : nums) {
                if ((n & rightmostbit) != 0)
                    xor1 ^= n;
                else
                    xor0 ^= n;
            }
            for (int i = 1; i <= nums.length; i++) {
                if ((i & rightmostbit) != 0)
                    xor1 ^= i;
                else
                    xor0 ^= i;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == xor0)
                    return new int[]{xor0, xor1};
            }
            return new int[]{xor1, xor0};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SetMismatch().new Solution();
        int[] errorNums = s.findErrorNums(new int[]{1, 2, 2, 4});
        A.p(errorNums);

        System.out.println(1 ^ 2 ^ 3 ^ 4 ^ 1 ^ 2 ^ 2 ^ 4);
    }
}