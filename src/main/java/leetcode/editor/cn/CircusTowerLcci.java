package leetcode.editor.cn;
//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。 
//
// 示例： 
//
// 
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190) 
//
//
// 提示： 
//
// 
// height.length == weight.length <= 10000 
// 
// Related Topics 排序 二分查找 动态规划 
// 👍 49 👎 0

import java.util.Arrays;

public class CircusTowerLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            int[][] a = new int[height.length][2];
            for (int i = 0; i < height.length; i++) {
                a[i][0] = height[i];
                a[i][1] = weight[i];
            }
            Arrays.sort(a, (x, y) -> {
                return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
            });
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new CircusTowerLcci().new Solution();
    }
}





























































