#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i<=b;i++)

void recursive_helper(vector<int>& nums, int index, vector<int>& temp, int cur_sum, vector<vector<int>>& answer, int target){

    if(cur_sum > target){
        return;
    }
    
    //base case; 
    if(index == nums.size()){
        if(cur_sum != target) return;
        
        vector<int> temp_ans;
        for(int num: temp){
            temp_ans.push_back(num);
        }
        answer.push_back(temp_ans);        
    }

    //include number; 

    temp.push_back(nums[index]);
    recursive_helper(nums, index+1, temp, cur_sum + nums[index], answer, target);
    temp.pop_back();
    recursive_helper(nums, index+1, temp, cur_sum, answer, target);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    int n, k; 
    cin >> n >> k; 
    vector<int> nums(n);
    rep(i,0,n-1) cin >> nums[i];

    vector<vector<int>> answer; 
    vector<int> temp; 

    recursive_helper(nums, 0, temp, 0, answer, k);

    rep(i,0,answer.size()-1){
        rep(j,0,answer[i].size()-1){
            cout << answer[i][j] << " ";
        }
        cout << "\n";
    }
}