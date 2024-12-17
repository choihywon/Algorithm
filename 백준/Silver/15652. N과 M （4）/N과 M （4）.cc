#include <iostream>
#include <vector>

using namespace std;

void dfs(int n, int m, vector<int>& sequence, int start) {
	if (sequence.size() == m) {
		for (int num : sequence)  // for(char c : sequence)
			cout << num << " ";
		cout << '\n';
		return;
	}
	for (int i = start; i <= n; i++) {
		sequence.push_back(i);
		dfs(n, m, sequence, i);
		sequence.pop_back();
	}
}


int main() {
	int n, m;
	cin >> n >> m;
	vector<int> sequence;
	dfs(n, m, sequence, 1);
	return 0;
}