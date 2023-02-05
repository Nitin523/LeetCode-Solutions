// Assuming ListNode Implementation is there for the linkedList.
// Check for first node and the last node once found equal then change the ref from head to head.next means next node
// If not return false


class PalindromeCheck {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;
        return checkPalindrome(ref);
    }

    public boolean checkPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        boolean ans = checkPalindrome(head.next);
        boolean isPalindrome = (ref.val == head.val) ? true: false;
        ref = ref.next;
        return ans && isPalindrome;
    }
}

