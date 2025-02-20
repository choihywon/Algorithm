class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
        for (String word : babbling) {
            int index = 0;
            boolean isValid = true;

            while (index < word.length()) {
                boolean found = false;
                for (String babyWord : baby) {
                    int len = babyWord.length();
                    
                    if (index + len <= word.length()) {
                        String sub = word.substring(index, index + len);
                        if (sub.equals(babyWord)) {
                            index += len;
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
