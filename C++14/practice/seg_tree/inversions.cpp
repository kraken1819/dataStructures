#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

int MAX_N = 3 + 1e5; 

vector<int> visited_seg_tree(4 * MAX_N);

void update_seg_tree(int v, int l, int r, int val){

    if( l == r ){
        visited_seg_tree[v]++; 
        return;
    }

    int mid = l + ( r - l ) / 2; 

    if(val <= mid)
        update_seg_tree(2*v, l, mid, val);
    else
        update_seg_tree(2*v+1, mid+1, r, val);

    visited_seg_tree[v]++;
}

int get_seg_sum(int v, int l, int r, int tl, int tr){
    if(tl > tr)
        return 0;
    
    if(tl == l && tr == r){
        return visited_seg_tree[v];
    }

    int mid = l + ( r - l ) / 2; 

    return (
        get_seg_sum(2*v, l, mid, tl, min(tr, mid)) +
        get_seg_sum(2*v+1, mid+1, r, max(tl, mid+1), tr)
    );
}

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; 
    cin >> n; 
    int temp;

    rep(i,0,n-1){
        cin >> temp;
        cout << get_seg_sum(1, 1, n, temp+1, n) << " ";
        update_seg_tree(1, 1, n, temp);
    }
}