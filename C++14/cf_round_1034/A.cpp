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
    while(tc-->0){
        int n; cin >> n;
        if(n%4 == 0){
            cout << "Bob" << "\n";
            continue;
        } 
        cout << "Alice" << "\n";
    }
    
}