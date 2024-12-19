#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int m, vector<int>& nums, vector<int>& sequence, int start) {
	if (sequence.size() == m) {
		for (int num : sequence)  
			cout << num << " ";
		cout << '\n';
		return;
	}
	for (int i = start; i < nums.size(); i++) {
		sequence.push_back(nums[i]);
		dfs(m, nums, sequence, i+1);
		sequence.pop_back();
	}
}


int main() {
	int n, m;
	cin >> n >> m;

	vector<int> nums(n);
	for (int i = 0; i < n; i++) {
		cin >> nums[i];
	}
	sort(nums.begin(), nums.end());

	vector<int> sequence;
	dfs(m, nums, sequence, 0);
}