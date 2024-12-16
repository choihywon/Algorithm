import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        //leave 하다보니 메세지도 저장할 필요성을 느낌
        List<String[]> list = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        //사용자 아이디 저장
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            //들어옴
            if(arr[0].equals("Enter")) {
                user.put(arr[1], arr[2]);
                list.add(new String[] { "Enter", arr[1] });
            }
            //ID 바꿈
            else if(arr[0].equals("Change")) {
                user.replace(arr[1], arr[2]);
            }
            //떠남
            else {
                list.add(new String[] { "Leave", arr[1] });
            }
        }

        //메세지 출력
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String[] result = list.get(i);
            //result[0] : 명령어 뭐였는지
            //result[1] : userId
            //user.get(id) : id로 이름 가져옴
            if(result[0].equals("Enter")) {
                answer[i] = user.get(result[1]) + "님이 들어왔습니다.";
            }
            else if(result[0].equals("Leave")) {
                answer[i] = user.get(result[1]) + "님이 나갔습니다.";
            }
            else {
                continue;
            }
        }

        return answer;
    }
}
