#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 
typedef pair<pair<int, int>, pair<int, int>> seg_type; 

int MAXN = 3 + 2e5; 

vector<seg_type> seg_tree(4 * MAXN); 

bool comparator(pair<int, int> a, pair<int, int> b){
    return a.first > b.first; 
}

seg_type merge(seg_type a, seg_type b){
    vector<pair<int, int>> temp; 

    temp.push_back(a.first);
    temp.push_back(a.second);
    temp.push_back(b.first);
    temp.push_back(b.second);

    sort(temp.begin(), temp.end(), comparator);

    rep(i,0,2){
        if(temp[i].first == temp[i+1].first){
            temp[i].second += temp[i+1].second;
            temp[i+1].first = 0;
            temp[i+1].second = 0;
        }
    }

    sort(temp.begin(), temp.end(), comparator);

    return make_pair(temp[0], temp[1]);
}

void build_seg_tree(int v, int l, int r, vector<int>& nums){
    if( l == r ){
        seg_tree[v].first = make_pair(nums[l], 1);
        seg_tree[v].second = make_pair(0,0);
        return;
    }

    int m = l + ( r - l ) / 2; 

    build_seg_tree(2*v, l, m, nums);
    build_seg_tree(2*v+1, m+1, r, nums);

    seg_tree[v] = merge(seg_tree[2*v], seg_tree[2*v+1]);
}

void update_seg_tree(int v, int l, int r, int ind, int value){
    if( l == r ){
        seg_tree[v].first.first = value; 
        return; 
    }

    int m = l + ( r - l ) / 2; 

    if( ind <= m )
        update_seg_tree(2*v, l, m, ind, value);
    else 
        update_seg_tree(2*v+1, m+1, r, ind, value);

    seg_tree[v] = merge(seg_tree[2*v], seg_tree[2*v+1]);
}

seg_type count_seg_tree(int v, int l, int r, int tl, int tr){
    if(tl > tr){
        return make_pair(make_pair(0,0), make_pair(0,0)) ; 
    }
    if( tl == l && tr == r ){
        return seg_tree[v];
    }

    int m = l + ( r - l ) / 2; 

    return merge(
        count_seg_tree(2*v, l, m, tl, min(tr,m)),
        count_seg_tree(2*v+1, m+1, r, max(tl,m+1), tr)
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

    while(q--){
        int type, first, last;
        cin >> type >> first >> last; 

        if(type == 1){
            update_seg_tree(1, 0, n-1, first-1, last);
            continue;
        }
        cout << count_seg_tree(1, 0, n-1, first-1, last-1).second.second << "\n";
    }
}