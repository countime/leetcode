package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2517 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rest=new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int a=0,c=len;
        while (a < c - 1) {
            for (int b = a + 1; b < c; b++) {
                int sum = a + b + c;
                if (sum == 0) {
                    rest.add(Arrays.asList(a, b, c));
                    break;
                } else if (sum < 0) {
                    continue;
                } else if(sum>0){
                    break;
                }
            }
            // TODO: 2020/8/25
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new ThreeSum().new Solution();
    }
}