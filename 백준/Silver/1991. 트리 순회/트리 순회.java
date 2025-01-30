import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value , Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static Node[] tree;

    //전위 순회
    public static void preorder(Node node) {
        if(node == null)
            return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void buildTree(int N, BufferedReader br) throws IOException {
        tree = new Node[26];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // 부모 노드가 없으면 생성
            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue, null, null);
            }

            // 왼쪽 자식 노드 생성 및 연결
            if (leftValue != '.') {
                if (tree[leftValue - 'A'] == null) {
                    tree[leftValue - 'A'] = new Node(leftValue, null, null);
                }
                tree[parentValue - 'A'].left = tree[leftValue - 'A']; 
            }

            // 오른쪽 자식 노드 생성 및 연결
            if (rightValue != '.') {
                if (tree[rightValue - 'A'] == null) {
                    tree[rightValue - 'A'] = new Node(rightValue, null, null);
                }
                tree[parentValue - 'A'].right = tree[rightValue - 'A']; 
            }
        }
    }

    public static Node getRoot() {
        return tree['A' - 'A'];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Solution solution = new Solution();
        Solution.buildTree(n, br);;
        Node root = Solution.getRoot();

        Solution.preorder(root);
        System.out.println();
        Solution.inorder(root);
        System.out.println();
        Solution.postorder(root);
        System.out.println();

    }
}