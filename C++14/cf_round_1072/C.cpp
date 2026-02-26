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

        pair<ll, ll> bound = make_pair(k,k);

        int time = 0 ; 
        bool possible = false; 

        while(bound.first <= n){

            if(bound.first <= n && n <= bound.second){
                cout << time << "\n";
                possible = true;
                break; 
            }
            
            bound.first = 2* bound.first -1; 
            bound.second = 2* bound.second + 1; 
            time++;

        }
        if(!possible) cout << -1 << "\n";
    }
}