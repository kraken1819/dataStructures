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
        int n; cin >> n; 
        if(n == 2){
            cout << 2 << "\n";
            continue;
        }

        if(n == 3){ 
            cout << 3 << "\n";
            continue;
        }

        cout << (n&1) << "\n";
    }

}