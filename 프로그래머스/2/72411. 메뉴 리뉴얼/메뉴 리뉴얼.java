import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {

        List<String> answerList = new ArrayList<>();

        for (int c : course) {

            Map<String, Integer> map = new HashMap<>();

            // 각 주문에서 조합을 찾음
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                bfs(chars, c, 0, "", map);
            }

            // 최대 빈도 계산 (직접 순회)
            int maxCount = 2;
            for (String key : map.keySet()) {
                int count = map.get(key);
                if (count > maxCount) {
                    maxCount = count;
                }
            }

            // 최대 빈도 조합을 결과에 추가
            for (String key : map.keySet()) {
                int count = map.get(key);
                if (count == maxCount) {
                    answerList.add(key);
                }
            }
        }

        // 사전 순 정렬 (간단한 정렬 방식 사용)
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if (answer[i].compareTo(answer[j]) > 0) {
                    String temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        return answer;
    }

    //n과 m 시리즈
    private void bfs(char[] chars, int length, int start, String current, Map<String, Integer> map) {

        if (current.length() == length) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            bfs(chars, length, i + 1, current + chars[i], map);
        }
    }
}

