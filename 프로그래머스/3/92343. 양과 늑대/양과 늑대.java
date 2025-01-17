import java.util.*;
class Node {
    int index;
    List<Node> children;

    public Node(int index, List<Node> children) {
        this.index = index; // 노드 인덱스 초기화
        this.children = children; // 자식 노드 리스트 초기화
    }
}


class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Node[] nodes = new Node[info.length];
        for(int i = 0; i<nodes.length; i++){
            nodes[i] = new Node(i, new ArrayList<>());
        }
        //부모가 자식 누구 델꼬 있나
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            nodes[parent].children.add(nodes[child]);
        }
        //일단 탐색 후보들
        List<Node> canNextNodes = new ArrayList<>(List.of(nodes[0]));
       return dfs(0,0, nodes[0],canNextNodes, info);
    }

    public int dfs(int wolf, int sheep, Node currentIndex, List<Node> canNextNodes, int[] info) {
        if (info[currentIndex.index] == 0) {
            sheep++;
        }
        else {
            wolf++;
        }
        //종료 조건
        if(wolf >= sheep)
            return 0;

        int maxSheep = sheep;

        //백트래킹
        List<Node> newIndex = new ArrayList<>(canNextNodes);
        //현재 노드 지워야함
        newIndex.remove(currentIndex);
        //자식
        newIndex.addAll(currentIndex.children);


        //탐색 가능한 노드들 비교
        for (Node nextNode : newIndex) {
            // 복사된 리스트로 재귀 호출
            List<Node> nextNodesForCall = new ArrayList<>(newIndex);
            maxSheep = max(maxSheep, dfs(wolf, sheep, nextNode, nextNodesForCall, info));
        }
        return maxSheep;
    }

    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}