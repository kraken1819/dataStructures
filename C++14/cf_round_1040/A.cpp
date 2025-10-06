#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc;
    cin >> tc;
    while(tc--){
        int n; cin >> n; 
        int nums[n];
        for (int i=0; i<n; i++){
            cin >> nums[i];
        }

        int zero_count = 0;
        ll ans = 0 ; 
        for (int i=0; i<n; i++) {
            if ( nums[i] == 0 ){
                ans ++; 
                continue;
            }
            ans += nums[i];
        }
    
        cout << ans << "\n";
    }
}