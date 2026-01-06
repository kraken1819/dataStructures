#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

int MAXN = 3 + 1e5;

vector<int> min_seg_tree(4 * MAXN);

void build_seg_tree(int v, int l, int r, vector<int>& nums){
    if( l == r ){
        min_seg_tree[v] = nums[l];
        return; 
    }

    int mid = l + ( r - l ) / 2; 

    build_seg_tree(2*v, l, mid, nums);
    build_seg_tree(2*v+1, mid+1 ,r, nums);

    min_seg_tree[v] = min(min_seg_tree[2*v], min_seg_tree[2*v+1]);
}

void set_seg_tree(int v, int l, int r, int ind, int val){
    if( l == r ){
        min_seg_tree[v] = val;
        return;
    }

    int mid = l + ( r - l ) / 2;

    if(ind <= mid)
        set_seg_tree(2*v, l, mid, ind, val);
    else 
        set_seg_tree(2*v+1, mid+1, r, ind, val);

    min_seg_tree[v] = min(min_seg_tree[2*v], min_seg_tree[2*v+1]);
}

int get_seg_tree(int v, int l, int r, int tl, int tr){
    if( tl > tr ){
        return 1 + 1e9; 
    }

    if( tl == l && tr == r)
        return min_seg_tree[v];

    int mid = l + ( r - l ) / 2; 

    return min(
        get_seg_tree(2*v, l, mid, tl, min(tr,mid)),
        get_seg_tree(2*v+1, mid+1, r, max(tl,mid+1), tr)
    );
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q; 
    cin >> n >> q; 

    vector<int> nums(n);
    rep(i,0,n-1) cin >> nums[i];

    build_seg_tree(1, 0, n-1, nums);

    rep(i,0,q-1){

        int type, first, last;
        cin >> type >> first >> last;

        if(type == 1){
            set_seg_tree(1, 0, n-1, first, last);
            continue;
        }

        cout << get_seg_tree(1, 0, n-1, first, last-1) << "\n"; 
    }
}