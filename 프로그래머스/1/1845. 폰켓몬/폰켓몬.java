import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> kind = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            kind.add(nums[i]);
        }
        if(kind.size() > nums.length/2)
            answer = nums.length/2;
        else
            answer = kind.size();
        return answer;
    }
}