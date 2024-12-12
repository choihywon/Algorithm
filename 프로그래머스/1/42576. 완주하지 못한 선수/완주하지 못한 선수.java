import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> p = new HashMap<>();
        //참가자를 hashmap에 추가하기
        for (int i = 0; i < participant.length; i++) {
            p.put(participant[i], p.getOrDefault(participant[i], 0) + 1);
        }
        //완주한사람 처리해야함
        for(int i = 0; i < completion.length; i++) {
            String name = completion[i];
            int count = p.get(name);
            //완주자 이름 보이면 그 사람 카운트 줄여야함
            p.put(name, count - 1);
        }
        //완주못한사람 찾아야함
        for(String key : p.keySet()) {
            if(p.get(key) == 1) {
                return key;
            }
        }
        return "";
    }
}
