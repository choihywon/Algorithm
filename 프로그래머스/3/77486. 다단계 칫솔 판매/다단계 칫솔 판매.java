import java.util.*;


class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 부모,자식 관계를 담기 위한 map 생성
        Map<String, String> recommend = new HashMap<>();
        //수익
        Map<String, Integer> total = new HashMap<>();

        //추천받은 사람(자식) - 추천 한 사람(부모)
        for(int i = 0; i < enroll.length; i++) {
            recommend.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < enroll.length; i++) {
            total.put(enroll[i],0);
        }
        //youn 1200원 들어옴
        //edward를 찾음 -> 1200/10: 120원 young: 1200-120
        //marry를 찾음 -> 120/10 : 12원 edward 120-12
        //민호 찾음 -> 12/10 : 1원 marry 12-1
        for(int i = 0; i<seller.length; i++) {
            int money = amount[i]*100;
            String name = seller[i];
            count(name,money,recommend,total);
        }

        for(int i = 0; i < enroll.length; i++) {
            answer[i] = total.get(enroll[i]);
        }
        return answer;
    }
    public static void count(String name, int money, Map<String, String> recommend, Map<String, Integer>total) {
        //root 만나기 전까지만
        if(name.equals("-")||money<1) {
            return;
        }
        int benefit = money/10;
        int childMoney = money-benefit;
        int updateMoney = total.get(name) + childMoney;
        total.replace(name,updateMoney);
        count(recommend.get(name),benefit,recommend,total);
    }
}