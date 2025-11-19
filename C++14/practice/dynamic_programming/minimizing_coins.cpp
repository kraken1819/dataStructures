#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    int n, x; 
    cin >> n >> x;

    int coins[n];
    rep(i,0,n-1) cin >> coins[i];

    int dp[x+1] = {};

    rep(i,1,x){
        dp[i] = INT_MAX;

        rep(j,0,n-1){
            if(coins[j] <= i) dp[i] = min(dp[i], dp[max(i-coins[j], 0)] + 1);
        }
    }
    int ans = (dp[x] == INT_MAX) ? -1 : dp[x];

    cout << ans << "\n";
}