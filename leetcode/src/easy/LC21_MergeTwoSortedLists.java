package easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
/**
 * @ClassName: LC21_MergeTwoSortedLists
 * @Description: 合并两个有序链表
 * @Author: 余佳东
 * @Date: 2018-12-04 16:32
 * @Version: V1.0
 **/
public class LC21_MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description:  归并算法。 16 ms, 在Merge Two Sorted Lists的Java提交中击败了57.22% 的用户
     * @Param: [l1, l2]
     * @Return: easy.LC21_MergeTwoSortedLists.ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*ListNode node1 = new ListNode(l1.val);
        ListNode node2 = new ListNode(l2.val);*/
        ListNode head = null;
        ListNode tmp = null;
        int i = 0;

        while (l1 != null && l2 != null) {
            if (l2.val >= l1.val) {
                if(i == 0) {
                    head = l1;
                    tmp = l1;
                } else {
                    tmp.next = l1;
                    tmp = tmp.next;
                }

                l1 = l1.next;
            } else {
                if(i == 0) {
                    head = l2;
                    tmp = l2;
                } else {
                    tmp.next = l2;
                    tmp = tmp.next;
                }

                l2 = l2.next;
            }
            i++;
        }

        while (l1 != null) {
            if(i == 0) {
                head = l1;
                tmp = l1;
            } else {
                tmp.next = l1;
                tmp = tmp.next;
            }
            l1 = l1.next;
            i++;
        }

        while (l2 != null) {
            if(i == 0) {
                head = l2;
                tmp = l2;
            } else {
                tmp.next = l2;
                tmp = tmp.next;
            }

            l2 = l2.next;
            i++;
        }
        return head;
    }

    /**
     * @Description: 打印链表
     * @Param: [head]
     * @Return: void
     */
    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = null;
        /*ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);*/
        new LC21_MergeTwoSortedLists().printListNode(new LC21_MergeTwoSortedLists().mergeTwoLists(a,b));
    }
}
