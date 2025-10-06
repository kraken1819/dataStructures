#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc;cin >> tc;

    while(tc--){
        int n; cin >> n;
        int nums[n];
        rep(i,0,n-1) cin >> nums[i];
        sort(nums, nums+n);
        ll cost = 0LL;

        rep(i,0,n-1){
            if(((n-1-i)&1) == 0) cost += nums[i];
        }
        cout << cost << "\n";
    }
}