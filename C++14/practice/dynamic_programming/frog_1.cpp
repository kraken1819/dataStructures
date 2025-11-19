#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)

int solve(int n, vector<int>& nums){

    int dp[n+1];


    dp[0] = 0;
    dp[1] = 0; 

    rep(i,2,n){
        dp[i] = min(dp[i-1] + abs(nums[i-1]-nums[i-2]), dp[i-2] + abs(nums[i-1]-nums[max(i-3,0)]));
    }

    return dp[n];
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n; 
    vector<int> nums(n);

    rep(i,0,n-1) cin >> nums[i];

    cout << solve(n, nums) << "\n";
}