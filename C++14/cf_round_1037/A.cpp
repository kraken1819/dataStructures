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
        int n;cin >> n; 

        int least = 9;

        while(n>0){
            least = min(least, n%10);
            n/=10;
        }
        cout << least << "\n";
    }
}