//83. 删除排序链表中的重复元素
//链表是排好序的
/**1.一次遍历法:
 * 如果当前cur与cur.next对应的元素相同，那么我们就将cur.next从链表中移除；
 * 否则说明链表中已经不存在其它与 cur对应的元素相同的节点，因此可以将cur指向cur.next。
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
/**2.快慢双指针法:
 * pre控制不断向前遍历
 * cur为答案链表的尾节点
 * 满足要求则加到cur中
 * ！注意！本身还是在原链表里操作，要与原链表断开，cur.next要置为null
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode pre = head, cur = head;
        while (pre != null) {
            if (cur.val != pre.val) {
                cur.next = pre;
                cur = cur.next;
            }
            pre = pre.next;
        }
        cur.next = null;
        return head;
    }
}
