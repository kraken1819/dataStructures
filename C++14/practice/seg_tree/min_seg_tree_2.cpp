#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a; i>=b; i--)

typedef long long ll; 
typedef pair<int, int> node_type;

int MAXN = 3 + 1e5;

vector<node_type> min_seg_tree(4 * MAXN);

node_type combine(node_type a, node_type b){

    if( a.first < b.first) 
        return a; 
    if( b.first < a.first)
        return b; 

    return make_pair(a.first, a.second+b.second);
}

void build_seg_tree(int v, int l, int r, vector<int>& nums){

    if( l == r ){
        min_seg_tree[v] = make_pair(nums[l], 1);
        return;
    }

    int mid = l + ( r - l ) / 2; 

    build_seg_tree(2*v, l, mid, nums);
    build_seg_tree(2*v+1, mid+1, r, nums);

    min_seg_tree[v] = combine(min_seg_tree[2*v], min_seg_tree[2*v+1]);
}

void update_seg_tree(int v, int l, int r, int ind, int val){

    if( l == r ){
        min_seg_tree[v] = make_pair(val, 1);
        return;
    }

    int mid = l + ( r - l ) / 2; 

    if(ind <= mid)
        update_seg_tree(2*v, l, mid, ind, val);
    else 
        update_seg_tree(2*v+1, mid+1, r, ind, val);

    min_seg_tree[v] = combine(min_seg_tree[2*v], min_seg_tree[2*v+1]);

}

node_type get_seg_tree(int v, int l, int r, int tl, int tr){
    if ( tl > tr ){
        return make_pair(1 + 1e9, 1);
    }

    if( tl == l && tr == r){
        return min_seg_tree[v];
    }
    int mid = l + ( r - l ) / 2;

    return combine(
        get_seg_tree(2*v, l, mid, tl, min(tr, mid)),
        get_seg_tree(2*v+1, mid+1, r, max(tl, mid+1), tr)
    );
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m; 

    vector<int> nums(n);
    rep(i,0,n-1) cin >> nums[i];

    build_seg_tree(1, 0, n-1, nums);

    rep(i,0,m-1){
        int type, first, last;
        cin >> type >> first >> last;

        if( type == 1 ){
            update_seg_tree(1, 0, n-1, first, last);
            continue;
        }

        node_type ans = get_seg_tree(1,0,n-1, first, last-1);
        cout << ans.first << " " << ans.second << "\n";

    }
}

