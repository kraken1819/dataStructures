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
        int n, k; cin >> n >> k; 
        vector<int> nums(n); 
        rep(i,0,n-1) cin >> nums[i]; 

        set<int> missing; 
        vector<int> freq(k); 

        rep(i,0,k) missing.insert(i); 

        //first window. 

        rep(i,0,k-1){
            if( nums[i] < k ){
                freq[nums[i]]++; 
                missing.erase(nums[i]);
            }
        }

        int current_mex = *missing.begin(); 
        int max_mex = current_mex; 

        //slide the window

        rep(i,1,n-k){
            int in = nums[i+k-1]; 
            if(in < k){
                freq[in]++;
                missing.erase(in); 
            }

            int out = nums[i-1];
            if(out < k){
                freq[out]--;
                if(freq[out] == 0) missing.insert(out);
            }

            current_mex = *missing.begin();
            max_mex = max(max_mex, current_mex);
        }


        if(max_mex == k){
            cout << max_mex -1 << "\n";
            continue;
        }
        
        cout << max_mex << "\n";

    }
}