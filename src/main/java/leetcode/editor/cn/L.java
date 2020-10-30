package leetcode.editor.cn;

public class L {
    public static ListNode of(int... x) {
        ListNode s = new ListNode(0);
        ListNode end = s;
        for (int i : x) {
            ListNode e = new ListNode(i);
            end.next = e;
            end = e;
        }
        return s.next;
    }

    public static void main(String[] args) {
        System.out.println(L.of(1,2,3));
    }
}