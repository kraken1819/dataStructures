#include <bits/stdc++.h>
using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    //B

    int tc; cin >> tc;
    while(tc-->0){
        int n,j,k; 
        cin >> n >> j >> k;
        j--;
        int s[n]; 
        rep(i,0,n-1) cin >> s[i];

        int maxi = -9999; 
        int maxi_count = 0; 

        rep(i,0,n-1){
            if(s[i] > maxi){
                maxi = s[i];
                maxi_count = 1;
                continue;
            }
            if(s[i] == maxi)
                maxi_count++;
        }
        // cout << maxi << ":" << maxi_count << " " ;
        if(maxi != s[j] && k > 1){
            cout << "YES" << "\n";
            continue;
        }

        if(maxi == s[j]){

            cout << "YES" << "\n";
            continue;
        }
        cout << "NO" << "\n";
    }
}