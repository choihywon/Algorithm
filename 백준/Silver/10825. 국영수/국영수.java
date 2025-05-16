import java.io.*;
import java.util.*;

class Score {
    String Name;
    int Korean;
    int English;
    int Math;

    public Score(String Name, int korean, int english, int math) {
        this.Name = Name;
        Korean = korean;
        English = english;
        Math = math;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       List<Score> list = new ArrayList<>();


       for(int i = 0 ; i < n; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           String name = st.nextToken();
           int korean = Integer.parseInt(st.nextToken());
           int english = Integer.parseInt(st.nextToken());
           int math = Integer.parseInt(st.nextToken());

           list.add(new Score(name, korean, english, math));
       }

       list.sort(new Comparator<Score>() {
           @Override
           public int compare(Score o1, Score o2) {
               if(o1.Korean != o2.Korean)
                   return o2.Korean - o1.Korean;
               if(o1.English != o2.English)
                   return o1.English - o2.English;
               if(o1.Math != o2.Math)
                   return o2.Math - o1.Math;
               return o1.Name.compareTo(o2.Name);
           }
       });

       StringBuilder sb =new StringBuilder();
       for(Score s : list) {
           sb.append(s.Name).append("\n");
       }

       System.out.println(sb);


    }
}