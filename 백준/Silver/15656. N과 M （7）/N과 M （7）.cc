#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<int> numbers;  // 입력받은 숫자를 저장할 벡터
vector<int> sequence; // 현재 수열을 저장할 벡터

void backtrack(int depth) {
    // M개의 숫자를 고르면 출력
    if (depth == M) {
        for (int num : sequence) {
            cout << num << " ";
        }
        cout << "\n";
        return;
    }

    // 모든 숫자를 탐색하며 수열 생성
    for (int i = 0; i < N; i++) {
        sequence.push_back(numbers[i]); // 숫자를 추가
        backtrack(depth + 1);          // 다음 깊이로 이동
        sequence.pop_back();           // 상태를 복구
    }
}

int main() {
    cin >> N >> M;
    numbers.resize(N);

    for (int i = 0; i < N; i++) {
        cin >> numbers[i];
    }

    sort(numbers.begin(), numbers.end()); // 사전 순 출력을 위해 정렬

    backtrack(0); // 백트래킹 시작
    return 0;
}
