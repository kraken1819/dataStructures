#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k; cin >> n >> k; 
    vector<int> nums(n);

    rep(i,0,n-1) cin >> nums[i];

    ll dp[n+1];

    dp[1] = 0; 

    rep(i,2,n){
        dp[i] = dp[i-1] + abs(nums[i-1]-nums[i-2]);

        drep(j,i-2,max(i-k,1)){
            dp[i] = min(dp[i], dp[j] + abs(nums[i-1]-nums[i-j-2]));
        }
        cout << i << " " << dp[i] << "\n";
    }

    rep(i,1,n) cout << dp[i] << " , " ;
    cout << "\n";
    cout << dp[n] << "\n";
}