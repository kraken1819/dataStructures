#include <bits/stdc++.h>
using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

void print_answer(vector<int>& ans){
    rep(i,0,ans.size()-1) cout << ans[i] << " ";
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc; cin >> tc; 
    while(tc--){
        int n; cin >> n; 
        
        vector<int> nums(n);

        rep(i,0,n-1) cin >> nums[i] ; 

        int max_value = INT_MIN; 

        if(n == 1){
            print_answer(nums);
            continue;
        }

        rep(i,0,n-1){
            max_value = max(max_value, nums[i]);

            if(i+1 == max_value){
                int temp = nums[i];
                nums[i] = nums[n-1];
                nums[n-1] = temp; 
                break; 
            }
        }
        print_answer(nums);

    }
}