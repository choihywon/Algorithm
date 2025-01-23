import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> set = new HashSet<>();
        for(int i = 1; i<words.length; i++){
            String lastword = words[i-1];
            String firstword = words[i];

            if(set.contains(firstword) || firstword.charAt(0) != lastword.charAt(lastword.length()-1)) {
               int person = (i%n)  +1;
               int turn = (i/n) +1;
               answer[0] = person;
               answer[1] = turn;
               return answer;
            }
            set.add(lastword);
        }

        return answer;
    }
}