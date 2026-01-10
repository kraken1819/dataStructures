#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr); 

    int tc; cin >> tc; 
    while(tc -- ) { 
        int n; cin >> n; 
        vector<int> nums(n); 
        bool containszero = false;

        
        rep(i,0,n-1){
            cin >> nums[i]; 
            if(nums[i] == 0) containszero = true; 
        }

        if(!containszero){
            cout << "alice" << "\n";
            continue;
        }
        if(nums[0] == 1 || nums[n-1] == 1){
            cout << "alice" << "\n";
            continue;
        }
        cout << "bob" << "\n";
    }

}