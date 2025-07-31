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
        int a, b, x, y;
        cin >> a >> b >> x >> y;

        if(a == b){
            cout << 0 << "\n";
            continue;
        }else if(a > b){
            if(b == a-1 && ((a&1)==1)) cout << y << "\n";
            else cout << -1 << "\n";
            continue;
        }

        int e_count = (b - a)/2;
        int o_count = e_count;
        if ( (b-a)&1 ){
            if(a&1) o_count++;
            else e_count++;
        }

        ll answer = 0 ; 
        answer += o_count*x;
        if(y < x) answer += e_count*y;
        else answer += e_count*x;
        cout << answer << "\n";
    }
}