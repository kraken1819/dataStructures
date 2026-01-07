#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

int MAXN = 3 + 3e4; 

typedef vector<int> seg_type;

vector<seg_type> sorted_seg_tree(4*MAXN);

seg_type merge(seg_type& a , seg_type& b){
    seg_type ans; 

    int i = 0; 
    int j = 0; 

    while(i < a.size() && j < b.size()){
        if(a[i] < b[j])
            ans.push_back(a[i++]);
        else 
            ans.push_back(b[j++]); 
    }
    while(i < a.size()) ans.push_back(a[i++]);
    while(j < b.size()) ans.push_back(b[j++]);

    return ans;
}

void build_seg_tree(int v, int l, int r, vector<int>& nums){

    if( l == r ){
        sorted_seg_tree[v].push_back(nums[l]);
        return;
    }

    int m = l + ( r - l ) / 2; 

    build_seg_tree(2*v, l, m, nums);
    build_seg_tree(2*v+1, m+1, r, nums);

    sorted_seg_tree[v] = merge(sorted_seg_tree[2*v], sorted_seg_tree[2*v+1]);
}

int count_seg_tree(int v, int l, int r, int tl, int tr, int value){
    if( tl > tr ) return 0; 

    if( tl == l && tr == r ){
        seg_type t = sorted_seg_tree[v];
        return t.end() - upper_bound(t.begin(), t.end(), value); 
    }

    int m = l + ( r - l ) / 2; 

    return ( 
        count_seg_tree(2*v, l, m, tl, min(tr,m), value) + 
        count_seg_tree(2*v+1, m+1, r, max(tl, m+1), tr, value)
    );
}
int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n; 
    vector<int> nums(n);
    rep(i,0,n-1) cin >> nums[i];

    build_seg_tree(1, 0, n-1, nums); 

    int q; cin >> q; 
    while(q--){
        int i, j, k; 
        cin >> i >> j >> k; 
        cout << count_seg_tree(1, 0, n-1, i-1, j-1, k) << "\n";
    }
}