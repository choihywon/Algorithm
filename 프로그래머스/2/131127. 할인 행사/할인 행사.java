import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //일단 원하는 물품, 수량 넣어둠
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
           map.put(want[i], number[i]);
        }

        //(10일 구간 확인해야함)
        for(int i = 0; i<=discount.length - 10; i++) {
            Map<String, Integer> possibleMap = new HashMap<>();
            //10일동안 할인하는 품목, 수량 넣어둠
            for(int j = 0; j<10; j++) {
                possibleMap.put(discount[i + j], possibleMap.getOrDefault(discount[i + j], 0) + 1);
            }
            //원하는 것과 물품 수량 확인해보는 것
            boolean isPossible = true;
            for (String key : map.keySet()) {
                if (possibleMap.getOrDefault(key, 0) < map.get(key)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
}