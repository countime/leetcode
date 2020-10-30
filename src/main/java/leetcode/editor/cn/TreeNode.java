package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    @Override
    public String toString() {
        LinkedList<TreeNode> list = new LinkedList();
        list.add(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        while (!list.isEmpty()) {
            TreeNode node = list.pollLast();
            //直接打印左右节点.
            sb.append(",").append(node.left == null ? "null" : node.left.val);
            sb.append(",").append(node.right == null ? "null" : node.right.val);

            if (node.left != null) {
                list.addFirst(node.left);
            }
            if (node.right != null) {
                list.addFirst(node.right);
            }
        }
        return sb.toString().replaceAll("(,null)*$", "");
    }


    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 逗号分隔,可以有中括号或没有
    public static TreeNode of(String s) {
        s = s.trim();
        char c1 = s.charAt(0);
        if (c1 == '(' || c1 == '[' || c1 == '{') {
            s = s.substring(1, s.length() - 1);
        }
        String[] val = s.split(",");
        return of(Arrays.stream(val).map(Integer::valueOf).toArray(Integer[]::new));
    }

    public static TreeNode of(Integer... val) {
        TreeNode root = new TreeNode(val[0]);
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);

        List<TreeNode> list;

        int j = 1;
        while (j < val.length) {
            list = tmp;
            tmp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                TreeNode left = new TreeNode(val[j++]);
                if (left != null) {
                    treeNode.left = left;
                    tmp.add(left);
                }
                if (j >= val.length) {
                    return root;
                }

                TreeNode right = new TreeNode(val[j++]);
                if (right != null) {
                    treeNode.right = right;
                    tmp.add(right);
                }
            }
        }
        return root;
    }

    private static TreeNode str2node(String s) {
        if ("null".equalsIgnoreCase(s)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }

    public static void main(String[] args) {
        TreeNode from = of("[3,0,4,null,2,null,null,1]");
        System.out.println(from);
    }
}