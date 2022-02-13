// Time : O(N^2)          Space : O(N)

class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq = new ArrayDeque<>();
        dq.push(new StringBuilder()); // In case the first char is NOT '(', need an empty StringBuilder.
        for (char c : s.toCharArray()) {
            if (c == '(') 
            { // need a new StringBuilder to save substring in brackets pair
                dq.offer(new StringBuilder());
            }
            else if (c == ')') 
            { // found a matched brackets pair and reverse the substring between them.
                StringBuilder end = dq.pollLast();
                dq.peekLast().append(end.reverse());
            }
            else { 
                // append the char to the last StringBuilder.
                dq.peekLast().append(c);
            } 
        }
        return dq.pollLast().toString();
    }
}