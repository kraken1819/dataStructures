#include <bits/stdc++.h>
using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc; cin >> tc;
    while(tc--){
        int n, k;
        cin >> n >> k;
        int a[n];
        rep(i,0,n-1) cin >> a[i];

        int ans = 0;
        int consecutive_days = 0;

        rep(i,0,n){
            if(a[i] == 0 && i< n){
                consecutive_days++;
                continue;
            }
            ans += (consecutive_days/(k+1)) + ((consecutive_days%(k+1))/k);
            consecutive_days = 0;
        }
        cout << ans << "\n";
    }
}