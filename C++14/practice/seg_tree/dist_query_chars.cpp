#include <bits/stdc++.h>

using namespace std;
#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

typedef map<char, int> seg_type;

const int MAX_N = 100000;

vector<seg_type> seg_tree(4*MAX_N);

seg_type combine(const seg_type& a, const seg_type& b){

    map<char, int> ans = a; 

    for(auto& i: b){
        if(ans.find(i.first) != ans.end()){
            ans[i.first] += i.second;
            continue;
        }
        ans[i.first] = i.second;
    }

    return ans;
}

void build_seg_tree(int v, int l, int r, const string& str){

    if(l == r){
        map<char, int> leaf;
        leaf[str[l]] = 1; 
        seg_tree[v] = leaf;
        return;
    }

    int m = l + ( r - l )/2; 

    build_seg_tree(2*v, l, m, str);
    build_seg_tree(2*v+1, m+1, r, str);
    seg_tree[v] = combine(seg_tree[2*v], seg_tree[2*v+1]);
}

void set_seg_tree(int v, int l, int r, int pos, char ch, string& str){

    if ( l == r ){
        seg_tree[v].clear();
        seg_tree[v][ch] = 1; 
        str[pos] = ch;
        return;
    }

    int mid = l + ( r - l ) / 2;

    if ( pos <= mid ) set_seg_tree(2*v, l, mid, pos, ch, str);
    else set_seg_tree(2*v+1, mid+1, r, pos, ch, str);

    seg_tree[v] = combine(seg_tree[2*v], seg_tree[2*v+1]);

}

seg_type get_seg_tree(int v, int l, int r, int tl, int tr){

    if( tl == l && tr == r ){
        return seg_tree[v];
    }

    if( tl > tr ) { 
        seg_type temp;
        return temp;
    }

    int m = l + ( r - l )/2;

    return combine(get_seg_tree(2*v, l, m, tl, min(m, tr)), 
        get_seg_tree(2*v+1, m+1, r, max(tl, m+1), tr)
    );
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string str; cin >> str;
    int n = str.size();

    //build initial segment tree
    build_seg_tree(1, 0, n-1, str);

    int q; cin >> q; 
    while(q--){
        int type; cin >> type;
        if(type == 1){
            int pos;
            char ch;
            cin >> pos >> ch;
            set_seg_tree(1, 0, n-1, pos-1, ch, str);
            continue;
        }

        int l, r;
        cin >> l >> r;
        l--; r--;
        cout << get_seg_tree(1, 0, n-1, l, r).size() << "\n";
        //output distinct characters..
    }
}