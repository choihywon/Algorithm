#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <sstream>
 
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> user;
    //map에 명령어 저장
    for (const auto& line : record) {
        stringstream ss(line);
        string message, id, nickname;
        ss >> message >> id;
       
        if (message == "Enter") {
            ss >> nickname;
            user[id] = nickname;
        }
        else if (message == "Change") {
            ss >> nickname;
            user[id] = nickname;
        }
    }

    for (const auto& line : record) {
        stringstream ss(line);
        string cmd, id;
        ss >> cmd >> id;
        if (cmd == "Enter") {
            answer.push_back(user[id] + "님이 들어왔습니다.");
        }
        else if (cmd == "Leave") {
            answer.push_back(user[id] + "님이 나갔습니다.");
        }
    }
    return answer;
}