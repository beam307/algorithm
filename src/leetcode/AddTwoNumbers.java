package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(l1, l2);

        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        addTwoNumbers(l3, l4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode result = null;
        int q = 0;

        while (true) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            int r = (sum + q) % 10;
            stringBuilder.append(r);
            q = (sum + q) / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (l1 == null && l2 == null) {
                if (q > 0) {
                    stringBuilder.append(q);
                }
                break;
            }
        }

        for (String value: stringBuilder.reverse().toString().split("")) {
            if (result == null) {
                result = new ListNode(Integer.parseInt(value));
            } else {
                result = new ListNode(Integer.parseInt(value), result);
            }
        }

        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val :" + val + ", next: " + (next != null ? next.val : "") + "\n";
    }
}
