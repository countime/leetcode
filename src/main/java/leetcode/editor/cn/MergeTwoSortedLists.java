  //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1230 👎 0

  
  package leetcode.editor.cn;
  public class MergeTwoSortedLists {
      public static void main(String[] args) {
          Solution solution = new MergeTwoSortedLists().new Solution();
          System.out.println(solution.mergeTwoLists(L.of(1, 2, 4), L.of(3, 5)));
      }
      //leetcode submit region begin(Prohibit modification and deletion)

      /**
       * Definition for singly-linked list.
       * public class ListNode {
       * int val;
       * ListNode next;
       * ListNode() {}
       * ListNode(int val) { this.val = val; }
       * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       * }
       */
      class Solution {
          //坚定不移的相信,该函数可以完成该目标
          public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
              // 有一个链表为空,直接返回另一个
              if (l1 == null) {
                  return l2;
              }
              if (l2 == null) {
                  return l1;
              }
              if (l1.val < l2.val) {
                  l1.next = mergeTwoLists(l1.next, l2);
                  return l1;
              } else {
                  l2.next = mergeTwoLists(l2.next, l1);
                  return l2;
              }
          }
//leetcode submit region end(Prohibit modification and deletion)

      }
  }