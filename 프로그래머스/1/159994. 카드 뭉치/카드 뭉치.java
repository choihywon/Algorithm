import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        for(String s : cards1) {
            q1.addLast(s);
        }
        for(String s : cards2) {
            q2.addLast(s);
        }
        for(String s : goal) {
            if(s.equals(q1.peek())) {
                q1.poll();
            }
            else if(s.equals(q2.peek())) {
                q2.poll();
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
}