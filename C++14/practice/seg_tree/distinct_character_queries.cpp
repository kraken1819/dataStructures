#include <bits/stdc++.h>
using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

int MAXN = 3 + 1e5; 

vector<int> distinct_seg_tree(4 * MAXN); 

void build_seg_tree(int v, int l, int r, string& stringu){
    if( l == r ) { 
        distinct_seg_tree[v] = (1 << (stringu[l] - 'a'));
        return; 
    }

    int m = l + ( r - l ) / 2; 

    build_seg_tree(2*v, l, m, stringu);
    build_seg_tree(2*v, m+1, r, stringu);

    distinct_seg_tree[v] = distinct_seg_tree[2*v] | distinct_seg_tree[2*v+1];
}

void update_seg_tree(int v, int l, int r, int ind, char ch){
    if ( l == r ) { 
        distinct_seg_tree[v] = (1 << (ch - 'a'));
        return;
    }

    int m = l + ( r - l ) / 2; 

    if(ind <= m) 
        update_seg_tree(2*v, l, m, ind, ch);
    else 
        update_seg_tree(2*v+1, m+1, r, ind, ch);

    distinct_seg_tree[v] = distinct_seg_tree[2*v] | distinct_seg_tree[2*v+1];
}

int count_seg_tree(int v, int l, int r, int tl, int tr){
    if( tl > tr ) { 
        return 0; 
    }

    if( tl == l && tr == r ) { 
        return distinct_seg_tree[v]; 
    }
    
    int m = l + ( r - l ) / 2; 

    return (
        count_seg_tree(2*v, l, m, tl, min(tr,m)) | count_seg_tree(2*v + 1, m+1, r, max(tl,m+1), tr)
    );
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string stringu;
    cin >> stringu; 

    int n = stringu.size(); 

    build_seg_tree(1, 0, n-1, stringu);

    //print seg tree 
    rep(i,0,4*n-1) cout << distinct_seg_tree[i] << " " ;
    cout << "\n";
    // 

    int q; cin >> q; 
    
    while(q--){
        int type; cin >> type ; 
        if( type == 1 ){
            int pos; 
            char ch; 
            cin >> pos >> ch; 
            update_seg_tree(1, 0, n-1, pos, ch);
            continue;
        }
        int l, r; 
        cin >> l >> r; 
        cout << __builtin_popcount(count_seg_tree(1, 0, n-1, l, r)) << "\n";
    }
}