package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 649 👎 0

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();
        int size = 0;

        public List<List<String>> solveNQueens(int n) {
            size = n;
            List<String> board = new ArrayList<>();

            back(board);
            return result;
        }

        private void back(List<String> board) {
            boolean valid = isValid(board);
//            if (valid) {
//                System.out.println("============");
//                A.p(board,"\n","\n");
//                System.out.println(valid);
//            }
            if (!valid) {
                return;
            }
            if (board.size() == size) {
                result.add(board);
                return;
            }

            // 当前要处理的数据是第几行
            int row = board.size();
            for (int i = 0; i < size; i++) {
                String s = qAt(i);
                List<String> cloneBoard=new ArrayList<>(board);
                board.add(s);
                back(board);
                board = cloneBoard;
            }
        }

        String qAt(int i) {
            char[] chars = new char[size];
            for (int j = 0; j < chars.length; j++) {
                chars[j] = '.';
            }
            chars[i] = 'Q';
            return new String(chars);
        }

        boolean isValid(List<String> board) {
            // 当前行的行号
            int row = board.size() - 1;
            if (row <= 0) {
                return true;
            }
            // 最后一行的Q的位置
            int col = board.get(row).indexOf("Q");
            // 检查列是否有皇后互相冲突
            for (int i = 0; i < row ; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1;
                 i >= 0 && j < size; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new NQueens().new Solution();
        System.out.println(s.solveNQueens(8).size());
        System.out.println(s.solveNQueens(9).size());
        System.out.println(s.solveNQueens(10).size());
        System.out.println(s.solveNQueens(11).size());
    }
}