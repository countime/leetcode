package leetcode.editor.cn;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 542 👎 0

public class WordSearch {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String word;
        private char[][] board;
        private boolean[][] marked;
        int m;
        int n;



        private int[][] derection = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public boolean exist(char[][] board, String word) {
            m=board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[board.length][board[0].length];
            this.word=word;
            this.board=board;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            if (i < 0 || i >= m) {
                return false;
            }
            if (j < 0 || j >= n) {
                return false;
            }
            if (board[i][j] != word.charAt(start)) {
                return false;
            }
            if(marked[i][j]){
                return false;
            }
            if (start == word.length() - 1) {
                return true;
            }

            marked[i][j] = true;
            start++;
            for (int[] delta : derection) {
                if (dfs(i + delta[0], j + delta[1], start)) {
                    return true;
                }
            }
            marked[i][j]=false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new WordSearch().new Solution();
        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(arr, "ABCB"));

    }
}