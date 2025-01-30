import java.io.*;

class Node {
    int num;
    Node left, right;

    public Node(int num) {
        this.num = num;
    }

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }


    public void insert(int n) {
        if (n < this.num) {
            if (this.left == null)
                this.left = new Node(n);
            else
                this.left.insert(n);
        } else {
            if (this.right == null)
                this.right = new Node(n);
            else
                this.right.insert(n);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine())); 
        String input;


        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }


    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
