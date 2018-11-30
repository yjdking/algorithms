package medium;

/**
 *给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

/**
 * @ClassName: LC2_AddTwoNumbers
 * @Description: Leetcode2_两数相加（两链表相加）
 * @Author: 余佳东
 * @Date: 2018-11-15 22:52
 * @Version: V1.0
 **/
 
public class LC2_AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);

        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        /*ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        l2.next = new ListNode(9);*/

        LC2_AddTwoNumbers test = new LC2_AddTwoNumbers();
        ListNode t = test.addTwoNumbers(l1, l2);
        System.out.println("1: " + t.val);
        System.out.println("2: " + t.next.val);
        System.out.println("3: " + t.next.next.val);
        // test.printList(test.addTwoNumbers(l1, l2));
    }

    /**
     * @Description:
     * @Param: [l1, l2]
     * @Return: medium.LC2_AddTwoNumbers.ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        int puls = 0;

        ListNode head = null;
        ListNode result = head;
        //ListNode tmpNode = null;

        while (l1 !=null || l2 != null || tmp != 0) {
            int vall1 = 0;
            int vall2 = 0;
            puls = tmp;
            tmp = 0;

            if(l1 != null) {
                vall1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                vall2 = l2.val;
                l2 = l2.next;
            }

            int sum = vall1 + vall2 + puls;
            if(sum >= 10) {
                sum = sum - 10;
                tmp = 1;
            }

            if(head == null) {
                head = new ListNode(sum);
                result = head;
            } else {
                head.next = new ListNode(sum);
                head = head.next;
            }

        }
        return  result;
    }

    /**
     * @Description: 打印链表
     * @Param: [l]
     * @Return: void
     */
    public void printList(ListNode l) {
        System.out.println("test");
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
