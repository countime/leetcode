package leetcode.editor.cn;
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表 
// 👍 399 👎 0

public class CopyListWithRandomPointer {

   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node curr = head;
            while (curr != null) {
                Node dup = new Node(curr.val);
                dup.next = curr.next;
                curr.next = dup;
                curr = dup.next;
            }

            curr = head;
            while (curr != null) {
                curr.next.random = curr.random == null ? null : curr.random.next;
                curr = curr.next.next;
            }


            curr = head;
            Node result = head.next;
            while (curr != null) {
                Node dup = curr.next;
                curr.next=dup.next;
                curr=dup.next;
                dup.next = dup.next == null ? null : dup.next.next;
            }
            return result;
        }

        public Node copyRandomList2(Node head) {
            Node curr = head;
            Node[] a1 = new Node[1000];
            Node[] a2 = new Node[1000];
            int idx = 0;

            Node prev = new Node(-1);
            while (curr != null) {
                Node e2 = new Node(curr.val);
                prev.next = e2;
                prev = e2;
                a2[idx] = e2;
                a1[idx++] = curr;
                curr = curr.next;
            }

            for (int i = 0; i < idx; i++) {
                Node node = a1[i];
                if (node.random != null) {
                    for (int j = 0; j < idx; j++) {
                        if (node.random == a1[j]) {
                            a2[i].random = a2[j];
                        }
                    }
                }
            }
            return a2[0];
        }

        public Node copyRandomList3(Node head) {
            if (head == null) {
                return null;
            }

            Node curr = head;
            while (curr != null) {
                Node dup = new Node(curr.val);
                dup.next = curr.next;
                curr.next = dup;
                curr = dup.next;
            }

            curr = head;
            Node result = head.next;
            while (curr != null) {
                Node dup = curr.next;
                dup.random = curr.random == null ? null : curr.random.next;


                if (dup.next != null) {
                    curr.next = curr.next.next;
                    dup.next = dup.next.next;
                } else {
                    curr.next = null;
                }
                curr = curr.next;
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new CopyListWithRandomPointer().new Solution();
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        n1.next=n2;
        Node node = s.copyRandomList(n1);
        System.out.println(node);
    }
}