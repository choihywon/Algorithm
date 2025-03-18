#include <iostream>
#include <stack>
#include <string> // 문자열을 사용하기 위해 필요합니다.

using namespace std;

int main() {
    int n;
    cin >> n;  

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str; 

        stack<char> st;  
        bool isValid = true;  

        for (char ch : str) {
            if (ch == '(') {
                st.push(ch);  
            } else if (ch == ')') {
                if (st.empty()) {
                    cout << "NO" << endl; 
                    isValid = false;
                    break;
                }
                st.pop();
            }
        }

      
        if (isValid && st.empty()) {
            cout << "YES" << endl;  
        } else if (isValid) {
            cout << "NO" << endl; 
        }
    }

    return 0;
}
