import java.io.*;
import java.util.*;

class Node {
    int id;
    List<Node> children = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}

class Tree {
    private Node[] nodes;
    private boolean[] deleted;
    private Node root;

    public Tree(int N, int[] parents) {
        nodes = new Node[N];
        deleted = new boolean[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        for (int child = 0; child < N; child++) {
            int parent = parents[child];
            if (parent == -1) {
                root = nodes[child];
            } else {
                nodes[parent].addChild(nodes[child]);
            }
        }
    }

    public void deleteNode(int deleteId) {
        deleted[deleteId] = true;
    }

    public int countLeafNodes() {
        if (deleted[root.id]) return 0;
        return countLeafDFS(root);
    }

    private int countLeafDFS(Node node) {
        if (deleted[node.id]) return 0;

        boolean isLeaf = true;
        int leafCount = 0;

        for (Node child : node.children) {
            if (!deleted[child.id]) {
                isLeaf = false;
                leafCount += countLeafDFS(child);
            }
        }

        if (isLeaf) {
            return 1;
        } else {
            return leafCount;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        int deleteNode = Integer.parseInt(br.readLine());

        Tree tree = new Tree(N, parents);
        tree.deleteNode(deleteNode);

        System.out.println(tree.countLeafNodes());
    }
}
