#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 100000;
int n, k;
int visited[MAX+1];

void bfs(int n, int k) {
    queue<int> q;
    fill(visited, visited + MAX + 1, -1);
    q.push(n);
    visited[n] = 0;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        int first = u + 1;
        int second = u - 1;
        int third = u * 2;
        if (first <= MAX && visited[first] == -1) {
            visited[first] = visited[u] + 1;
            if (first == k) {
                cout << visited[first] << endl;
                return;
            }
            q.push(first);
        }

        if (second >= 0 && visited[second] == -1) {
            visited[second] = visited[u] + 1;
            if (second == k) {
                cout << visited[second] << endl;
                return;
            }
            q.push(second);
        }

        if (third <= MAX && visited[third] == -1) {
            visited[third] = visited[u] + 1;
            if (third == k) {
                cout << visited[third] << endl;
                return;
            }
            q.push(third);
        }
    }
}

int main() {
    int n, k;
    cin >> n >> k;

    if (n == k) {
        cout << 0 << endl;
    }
    else {
        bfs(n, k);
    }

    return 0;
}