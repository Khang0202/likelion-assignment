package vn.edu.likelion.project.day09072024;

public class Bai1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode current = l1;
        int numNode = 0;
        while (current.next != null) {
            numNode++;
            current = current.next;
        }
        ListNode result = l1;
        int res = -1;
        for (int i = 0; i <= (numNode+1)/2 ; i++) {
            res = result.val;
            result = result.next;
        }
        System.out.println(res);
    }
}
