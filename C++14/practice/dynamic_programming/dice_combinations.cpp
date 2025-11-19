#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)

typedef long long ll;

const int mod = 1e9 + 7; 

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    int n; cin >> n; 
    
    ll dp[n+1];

    dp[0] = 1;

    ll cur_sum = 1; 
    rep(i,1,n){
        dp[i] = cur_sum; 
        cur_sum += dp[i];
        if(i-6 < 0){
            continue;
        }
        cur_sum = (cur_sum - dp[i-6] + mod) % mod;
    }

    cout << dp[n] << "\n";
}