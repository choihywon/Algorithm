import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {


        HashMap<String, Integer> reportmap = new HashMap<>();
        HashMap<String, Integer> countmap = new HashMap<>();

        //중복 신고를 먼저 제거해야둬야할 거 같음
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }

        //신고 당한 횟수((신고처리)

        for(String ss : set) {
            String[] reportlist = ss.split(" ");
            String gozazil = reportlist[0];
            String blacklist = reportlist[1];
            //신고당한 사람 처리 먼저(횟수)
            reportmap.put(blacklist, reportmap.getOrDefault(blacklist, 0) + 1);
            //신고 기록

        }
        //중복 신고 방지 -> 어 hashset이다

        //정지된 유저
        Set<String> blockList = new HashSet<>();
        for (String user : reportmap.keySet()) {
            if (reportmap.get(user) >= k) { // 정지 기준에 도달한 유저
                blockList.add(user);
            }
        }

        //신고 당한 횟수 계산
        int[] answer = new int[id_list.length];
        Map<String, Integer> mailCount = new HashMap<>();

        for (String entry : set) {
            String[] parts = entry.split(" ");
            String reporter = parts[0]; // 신고한 유저
            String reported = parts[1]; // 신고당한 유저

            if (blockList.contains(reported)) { // 정지된 유저인지 확인
                mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1);
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }

        return answer;


    }
}
