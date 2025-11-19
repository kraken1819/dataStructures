#include <bits/stdc++.h>

using namespace std; 

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n; 

    int ans = 0;
    int max_digit = 0;
    int temp;
    while(n){
        max_digit =0;
        temp = n;
        while(temp){
            max_digit = max(max_digit, temp%10);
            temp /= 10;
        }

        ans++;
        n -= max_digit;
    }
    cout << ans << "\n";
}