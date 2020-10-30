package leetcode.editor.cn;
//给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 排序 数组 
// 👍 25 👎 0

import java.util.Arrays;

public class SortTheMatrixDiagonally {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int row = mat.length;
            int col = mat[0].length;

            int min = Math.min(row, col);

            for (int r = 0; r < row; r++) {
                System.out.println("排序行:" + r);
                int cnt = Math.min(min, (row - r));
                int[] tmp = new int[cnt];
                for (int i = 0; i < cnt; i++) {
                    tmp[i] = mat[r + i][i];
                }
                Arrays.sort(tmp);
                for (int i = 0; i < cnt; i++) {
                    mat[r + i][i] = tmp[i];
                }
            }

            for (int c = 1; c < col; c++) {
                System.out.println("排序列:" + c);
                int cnt = Math.min(min, (col - c));
                int[] tmp = new int[cnt];
                for (int i = 0; i < cnt; i++) {
                    tmp[i] = mat[i][c + i];
                }
                Arrays.sort(tmp);
                for (int i = 0; i < cnt; i++) {
                    mat[i][c + i] = tmp[i];
                }
            }
            return mat;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SortTheMatrixDiagonally().new Solution();
        int[][] r = s.diagonalSort(new int[][]{new int[]{1, 2, 3}});
        A.p(r);
    }
}