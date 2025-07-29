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
        int n,c;
        cin >> n >> c; 
        int nums[n];
        rep(i,0,n-1) cin >> nums[i];

        sort(nums,nums+n);

        rep(i,0,n-1) cout << nums[i] <<" " ;
        cout << "\n";
        ll mul = 1; 

        int cost =0;
        drep(i,n-1,0){

            if(mul*nums[i] > c){
                cost++;
                continue;
            }
            mul *= 2;
        }
        cout << cost << "\n";
    }
    
    
}