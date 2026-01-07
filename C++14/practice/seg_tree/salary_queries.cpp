#include <bits/stdc++.h>
using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int MAXN = 3 + 2e5;

typedef pair<int, int> seg_type;

vector<seg_type> salary_seg_tree(4 * MAXN);

seg_type combine(seg_type a, seg_type b){
    return make_pair(min(a.first, b.first), max(a.second, b.second));
}

void build_seg_tree(int v, int l, int r, vector<int>& salaries){
    if( l == r ){
        salary_seg_tree[v] = make_pair(salaries[l], salaries[l]);
        return;
    }

    int m = l + ( r - l ) / 2;

    build_seg_tree(2*v, l, m, salaries);
    build_seg_tree(2*v+1, m+1, r, salaries);

    salary_seg_tree[v] = combine(salary_seg_tree[2*v], salary_seg_tree[2*v+1]);
}

void update_seg_tree(int v, int l, int r, int ind, int val){
    if( l == r ){
        salary_seg_tree[v] = make_pair(val, val);
        return;
    }

    int m = l + ( r - l ) / 2;

    if(ind <= m)
        update_seg_tree(2*v, l, m, ind, val);
    else 
        update_seg_tree(2*v+1, m+1, r, ind, val);

    salary_seg_tree[v] = combine(salary_seg_tree[2*v], salary_seg_tree[2*v+1]); 

}

int count_seg_tree(int v, int l, int r, int tl, int tr){

    int cur_min = salary_seg_tree[v].first;
    int cur_max = salary_seg_tree[v].second;

    if ( cur_max < tl || cur_min > tr){
        return 0;
    }

    if ( tl <= cur_min && cur_max <= tr ){
        return r - l + 1; 
    }

    int m = l + ( r - l ) / 2; 

    return (
        count_seg_tree(2*v, l, m, tl, tr) +
        count_seg_tree(2*v+1, m+1, r, tl, tr)
    );
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q; cin >> n >> q; 

    vector<int> nums(n);
    rep(i,0,n-1) cin >> nums[i];

    build_seg_tree(1, 0, n-1, nums);


    while(q--){
        char cmd;
        int first, last;
        cin >> cmd >> first >> last;

        if(cmd == '!'){
            update_seg_tree(1, 0, n-1, first-1, last);
            continue;
        }

        cout << count_seg_tree(1, 0, n-1, first, last) << "\n";
    }
}