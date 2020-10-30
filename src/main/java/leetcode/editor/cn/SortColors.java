package leetcode.editor.cn;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 683 👎 0

public class SortColors {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针,单次遍历
        public void sortColors(int[] nums) {
            int a=0,b=nums.length-1;
            for (int i = 0; i <= b; i++) {
                if (nums[i] == 0) {
                    int tmp = nums[a];
                    nums[a] = 0;
                    nums[i] = tmp;
                    a++;
                } else if (nums[i] == 2) {
                    int tmp = nums[b];
                    nums[b] = 2;
                    nums[i] = tmp;
                    b--;
                    i--;
                }
            }
//            A.p(nums);
        }

        public void sortColors1(int[] nums) {
            int[] cnt = new int[3];
            for (int num : nums) {
                cnt[num]++;
            }

            int idx = 0;
            for (int i = 0; i < cnt.length; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    nums[idx++] = i;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SortColors().new Solution();
        s.sortColors(new int[]{1, 2, 0});
    }
}