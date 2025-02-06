import java.util.*;
import java.io.*;

class Solution {
    private int n;
    private int[] parent;
    private int[] rank;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        //크루스칼
        //유니온 파인드를 통해서 일단 함
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = i;
        }

        //오름차순으로 정리
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        //가중치 작은 간선부터 합산
        //최종으로 mst 구성
        int edge =0;
        for(int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int weight = cost[2];
            //사이클 발생하지 않으면
            if(find(u) != find(v)) {
                union(u, v);
                answer+= weight;
                edge++;
                
                if(edge == n) break;
            }
        }
        
        return answer;
    }
    //유니온 파인드에서 중요한거
    //바로바로 부모 노드를 바탕으로 자식을 결합

    //
    private int find(int x) {
      if(parent[x] != x)
          parent[x] = find(parent[x]);
      return parent[x];
    }


    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
