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

        if(k == pow(n,2)-1){
            cout << "NO" << "\n";
            continue;
        }
        
        cout << "YES" << "\n";
        rep(i,1,n){
            if(k >= n){
                rep(j,0,n-1) cout << "U"; 
                cout << "\n";
                k-=n;
                continue;
            }
            if(k > 0){
                rep(j,0,k-1) cout << "U";
                if(i == n){
                    rep(q,1,n-k-1) cout << "R";
                    cout << "L" << "\n";
                    continue;
                }
                rep(j,1,n-k) cout << "D";
                cout << "\n";
                k = 0; 
                continue;
            }
            rep(j,1,n-1) cout << "R";
            cout << "L" << "\n";
        }
    }
}