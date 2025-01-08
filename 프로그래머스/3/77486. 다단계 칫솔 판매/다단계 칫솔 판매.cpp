#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
void count(string name, int money, unordered_map<string, string>& recommend, unordered_map<string, int>& total);

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    vector<int> answer(enroll.size());
    //자식-부모 관계
    unordered_map<string, string> recommend;
    //돈 계산
    unordered_map<string, int> total;
    for (int i = 0; i < referral.size(); i++) {
        recommend.insert({ enroll[i], referral[i] });
        total.insert({ enroll[i], 0 });
    }

    for (int i = 0; i < seller.size(); i++) {
        int money = amount[i] * 100;
        string name = seller[i];
        count(name, money, recommend, total);
    }
    for (int i = 0; i < enroll.size(); i++) {
        answer[i] = total[enroll[i]];
    }

    return answer;

}

void count(string name, int money, unordered_map<string, string>& recommend, unordered_map<string, int>& total) {
    if (name == "-" || money < 1)
        return;

    //부모한테 이익 나눠줘야함
    int benefit = money / 10;
    int childMoney = money - benefit;
    total[name] += childMoney;

    count(recommend[name], benefit, recommend, total);
}
