package leetcode.editor.cn;
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 431 👎 0

public class ValidSudoku {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int N = 9;
        public boolean isValidSudoku(char[][] board) {
            int[] rows = new int[N]; //行的位运算数组
            int[] cols = new int[N]; //列的位运算数组
            int[] boxes = new int[N]; //方格的位运算数组
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.')
                        continue;
                    int tmp = board[i][j] - '0';
                    int boxIndex = i / 3 * 3 + j / 3;
                    if ((rows[i] >> tmp & 1) == 1 //rows[i] >> tmp & 1取出第i行的tmp数字，看是否已填，如果等于1，代表已填
                            || (cols[j] >> tmp & 1) == 1 //cols[j] >> tmp & 1取出第j列的tmp数字，看是否已填，如果等于1，代表已填
                            || (boxes[boxIndex] >> tmp & 1) == 1) //boxes[boxIndex] >> tmp & 1取出第boxIndex个方格的tmp数字，看是否已填，如果等于1，代表已填
                        return false;
                    rows[i] = rows[i] | (1 << tmp); //将tmp数字加入到第i行的位运算数组
                    cols[j] = cols[j] | (1 << tmp); //将tmp数字加入到第j列的位运算数组
                    boxes[boxIndex] = boxes[boxIndex] | (1 << tmp); //将tmp数字加入到第boxIndex个方格的位运算数组
                }
            }
            return true;
        }

        public boolean isValidSudoku2(char[][] board) {
            for (int i = 0; i < 9; i++) {
                int r=0;
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    int xx = (1 << (c - '1'));
                    if (c != '.') {
                        if ((xx & r) > 0) {
                            return false;
                        }
                        r = r ^ xx;
                    }
                }
            }

            for (int i = 0; i < 9; i++) {
                int r=0;
                for (int j = 0; j < 9; j++) {
                    char c = board[j][i];
                    int xx = (1 << (c - '1'));
                    if (c != '.') {
                        if ((xx & r) > 0) {
                            return false;
                        }
                        r = r ^ xx;
                    }
                }
            }

            for (int i = 0; i < 9; i = i + 3) {
                for (int j = 0; j < 9; j = j + 3) {
                    int r = 0;
                    for (int a = i; a < 3 + i; a++) {
                        for (int b = j; b < 3 + j; b++) {
                            char c = board[a][b];
                            int xx = (1 << (c - '1'));
                            if (c != '.') {
                                if ((xx & r) > 0) {
                                    return false;
                                }
                                r = r ^ xx;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new ValidSudoku().new Solution();
    }
}