#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
typedef long long ll;

const int mod = 1e9 + 7; 

int solve(vector<int> coins, int target){

    int dp[target+1] = {};

    dp[0] = 1; 

    rep(i,0,target){
        for(int x: coins){
            if(i+x > target) continue;
            dp[i+x] += dp[i];
            dp[i+x] %= mod;
        }
    }   

    return dp[target];

}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    //input
    int n, x;
    cin >> n >> x;

    vector<int> coins(n);
    rep(i,0,n-1) cin >> coins[i];

    cout << solve(coins, x) << "\n";
}