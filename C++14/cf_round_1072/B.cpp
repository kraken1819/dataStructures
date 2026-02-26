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
        int s, k, m; 
        cin >> s >> k >> m; 

        int flip_count = m/k; 

        int sand_on_top; 

        if((flip_count & 1)){
            sand_on_top = min(s,k); 
        }else{
            sand_on_top = s;
        }

        sand_on_top -= (m%k);

        cout << max(sand_on_top,0) << "\n";

    }
}