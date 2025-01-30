import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree(n);
        tree.buildTree(br);
        tree.findParentsDFS(1,-1);
        tree.Parents();
    }
}

class Tree {
    public List<Integer>[] tree;
    public int[] parent;
    public int n;

    public Tree(int n){
        this.n = n;
        tree = new ArrayList[n+1];
        parent = new int[n+1];

        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
    }

    public void buildTree(BufferedReader br) throws IOException {
        for(int i = 0; i< n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
    }

    public void findParentsDFS(int current, int p) {
        parent[current] = p;
        for(int child : tree[current]) {
            if(parent[child] == 0) {
                findParentsDFS(child, current);
            }
        }
    }

    public void Parents() {
        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}