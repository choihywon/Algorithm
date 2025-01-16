import java.util.*;

class Node {
    int id;
    List<Node> children;

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<>();
    }
}

class Solution {
    public int solution(int[] info, int[][] edges) {
        // 트리 노드 생성
        Node[] nodes = new Node[info.length];
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
        }


        return dfs(nodes[0], 0, 0, new ArrayList<>(List.of(nodes[0])), info);
    }

    public int dfs(Node currentNode, int sheep, int wolf, List<Node> nextNodes, int[] info) {
        // 현재 노드에서 양 또는 늑대 수를 갱신
        if (info[currentNode.id] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return 0;
        }

        //노드 0 다음 노드 1, 2
        // 0 방문 양 = 1 늑대 = 0
        // 1 방문 양 = 2 늑대 = 0 다음 노드 2, 4
        // 4 방문 양 = 3 늑대 = 0 다음 노드 2 (4 자식 x)
        // 2 방문 양 = 1 늑대 = 1 늑대 < 양 (굿) 다음 노드 3
        // 3 방문 양 = 1 늑대 = 2 늑대 >= 양 (x) 반환 0
        //0 -> 1 -> 4


        int maxSheep = sheep;

        // 가능한 다음 노드 갱신
        List<Node> newNextNodes = new ArrayList<>(nextNodes);
        //현재 노드는 탐색 제외
        newNextNodes.remove(currentNode);
        newNextNodes.addAll(currentNode.children);

        // 모든 다음 노드에 대해 DFS 탐색
        for (Node nextNode : newNextNodes) {
            maxSheep = max(maxSheep, dfs(nextNode, sheep, wolf, newNextNodes, info));
        }

        return maxSheep;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}