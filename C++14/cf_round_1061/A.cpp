#include <bits/stdc++.h>

using namespace std;


#define rep(i, a, b) for(int i=a;i<=b;i++)
#define drep (i, a, b) for (int i=a; i>=b; i--)

typedef long long ll;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    //A
    int tc; cin >> tc;
    while (tc--) {
        int n; cin >> n;

        int ans = 0 ; 

        while ( n >= 3 ){
            ans += n/3; 

            n = n/3 + (n%3) ; 
        }

        cout << ans << "\n";
    }
}