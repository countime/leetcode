package leetcode.editor.cn;
//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 259 👎 0

public class IslandPerimeter{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for (int[] ints : grid) {
            int cols = ints.length;
            if (ints[0] == 1) {
                count++;
            }
            if (ints[cols-1] == 1) {
                count++;
            }
            for (int i = 0; i < ints.length-1; i++) {
                if (ints[i] != ints[i + 1]) {
                    count++;
                }
            }
        }

        int rows=grid.length;
        int cols=grid[0].length;

        for (int i = 0; i < cols; i++) {
            if (grid[0][i]==1) {
                count++;
            }
            if (grid[rows-1][i]==1) {
                count++;
            }

            for (int j = 0; j < rows - 1; j++) {
                if (grid[j][i] != grid[j + 1][i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new IslandPerimeter().new Solution();
        int[] r1 = {0,1,0,0};
        int[] r2 = {1,1,1,0};
        int[] r3 = {0,1,0,0};
        int[] r4 = {1,1,0,0};
        int[][] ints = new int[][]{r1,r2,r3,r4};
        System.out.println(s.islandPerimeter(ints));
    }
}