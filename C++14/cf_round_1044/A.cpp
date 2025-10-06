#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr); 

    int tc; cin >> tc;
    while(tc-- > 0 ){
        int n; cin >> n; 
        set<int> nums; 
        int temp;
        rep(i,0,n-1){
            cin >> temp;
            nums.insert(temp);
        } 
        if(nums.size() != n){
            cout << "YES" << "\n";
            continue;
        }
        cout << "NO" << "\n";
    }

}