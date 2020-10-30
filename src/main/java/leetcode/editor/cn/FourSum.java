package leetcode.editor.cn;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 549 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int l = nums.length;
            for (int i = 0; i < l - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                for (int j = i + 1; j < l - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[l - 2] + nums[l - 1] < target) {
                        continue;
                    }

                    int left = j + 1;
                    int right = l - 1;

                    int sum = target - nums[i] - nums[j];
                    while (left < right) {
                        if (left > j + 1 && nums[left] == nums[left - 1]) {
                            left++;
                            continue;
                        }
                        int s = nums[left] + nums[right];
                        if (s == sum) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;
                        } else if (s < sum) {
                            left++;
                        } else if (s > sum) {
                            right--;
                        }
                    }


                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new FourSum().new Solution();
        List<List<Integer>> lists = s.fourSum(new int[]{0, 0, 0, 0}, 0);

        System.out.println(lists);

    }
}