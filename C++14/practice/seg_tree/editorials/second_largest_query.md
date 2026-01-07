## Approach 

In this problem, for a selected range we have to find the frequency of second largest number...
while also allowing point update to values. 

### Naive Approach: Brute Force 

we store the values in an array,

For each **update** operation, we update the array using index-based access.

for each **count** operation, we would be iterating through the range and keeping track of 
`largest`, `second_largest`, `largest_count`, `second_largest_count`.

**Time Complexity** : 
    
    O(n * q) - number of queries * count operation

**Space Complexity** : 
    
    O(n) - for storing number in form of an array 

### OP Approach

The input size is `2e5` - which makes our solution's expected time complexity to 
be O(n * log n) (or) O(n * log <sup>2</sup> n). 

It costs O(n) for iterating through each of the query. which leaves us with O(log n) time complexity available.

what data structures allows point updates to happen in O(log n) ? - **SEGMENT TREE**

things we need to implementing segment tree- 

Node Info : 

    at each node, for a range I will be tracking the following things

    1. largest value
    2. second largest value
    3. largest value frequency
    4. second largest value frequency

    you can store them however you like, vector of pairs, pair of pairs, map Et cetera.

    But I'll be using pair<pair<int, int>, pair<int, int>>

merge function : 

    there are many ways for merging the largest, second largest information.
    but here is how I chose to do it.. not ideal, but works.

    1. I store all the pairs in the vector. 
    2. sort them. 
    3. merge same value ones. 
    4. sort them again to move the invalid ones to the last. 
    5. fetch the first 2 values. 

codeuuuu: 

```
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
```
