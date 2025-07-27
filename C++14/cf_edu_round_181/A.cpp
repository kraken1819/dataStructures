#include <bits/stdc++.h>
using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    //A

    int tc; cin >> tc;
    while(tc--){
        string str;cin >> str;
        int t_count = 0; 
        rep(i,0,str.length()-1){
            if(str[i] == 'T') t_count++;
        }
        string ans = ""; 
        rep(i,0,t_count-1) ans += 'T';
        rep(i,0,str.length()-1){
            if(str[i] != 'T') ans += str[i];
        }
        cout << ans << "\n";
    }
    
    
}