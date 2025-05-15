import java.io.*;
import java.util.*;

class map {
    int x;
    int y;

    public map(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       List<map> list = new ArrayList<>();

       for(int i = 0; i < n; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           int cX = Integer.parseInt(st.nextToken());
           int cY = Integer.parseInt(st.nextToken());

           list.add(new map(cX, cY));
       }

       list.sort(new Comparator<map>()  {
           @Override
           public int compare(map o1, map o2) {
               if(o1.x != o2.x)
                   return o1.x - o2.x;
               else
                   return o1.y - o2.y;
           }
       });

       StringBuilder sb = new StringBuilder();
       for(map m : list) {
           sb.append(m.x).append(" ").append(m.y).append("\n");
       }

       System.out.println(sb);

    }
}