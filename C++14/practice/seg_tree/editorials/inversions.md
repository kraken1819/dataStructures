## Approach

In this problem, at each position we need to find elements with larger value & lower index

### Naive Approach: Brute Force

At each position, we iterate through all the previous element and count element with larger value

**Time Complexity** : O(n^2)

**Space Complexity** : O(1)

### Not so Better Approach: Ordered Set

Is there a way to store previous element so that the time complexity of counting elements can be decreased ?? 

We include elements as we come across into an ordered set and find the location . 

```
#include <bits/stdc++.h>

using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

int main(){
    int n; 
    cin >> n; 
    vector<int> nums(n);

    rep(i,0,n-1) cin >> nums[i];

    set<int> ord_set;

    rep(i,0,n-1){
        ord_set.insert(nums[i]);

        cout << distance(ord_set.find(nums[i]), ord_set.end()) - 1 << " " ; 
    }
}
```

#### **Space Complexity Analysis** : 

    O(n) for storing elements in an ordered set. 
    
    O(n)

#### **Time Complexity** :
    O(n) for iterating through all the elements. 
    O(log n) for finding the location 
    Total time complexity of O(n * log n) ?? 

    Nope. that's what I initially thought. 
    std::distance() function for set has O(n) time complexity. 

    bumping up **Time Complexity** to 
    
    => O(n) * ( O(log n) + O(n))
    => O(n^2)

### OP Approach: Segment Tree

3 things to consider when implementing segment tree. 

1. what is the range on which segment tree is implemented ? 
2. what information does a single node hold 
3. merge/combine function. 

We will implement segment tree on values itself rather than the array positions. each leaf node stores 1 (or) 0. whether that number has occured or not. as we move up the tree, we store count of number occured till time. 

For each element, we search up segment tree for count of elements occured in the range (num+1, n). and include new element's status in the segment tree.

#### codeuuu:

```
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
```

