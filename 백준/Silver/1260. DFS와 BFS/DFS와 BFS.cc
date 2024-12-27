#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>


using namespace std;

int map[1001][1001];
int visited[1001];
int visited_bfs[1001];
queue<int> q;

void dfs(int n, int v) {
	visited[v] = 1;
	cout << v << " ";
	for (int i = 1; i <= n; i++) {
		if (visited[i] != 1 && map[v][i] == 1) {	
			dfs(n, i);
		}

	}
}
void bfs(int n, int v) {
	visited_bfs[v] = 1;
	q.push(v);
	cout << v << ' ';
	while (!q.empty()) {
		int p = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (map[p][i] == 1 && visited_bfs[i] == 0) {
				visited_bfs[i] = 1;
				cout << i << ' ';
				q.push(i);
				
			}
			
		}
	}
}

int main() {
	int n, m, v;
	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
		map[y][x] = 1;
	}
	dfs(n, v);
	cout << '\n';
	bfs(n, v);
}