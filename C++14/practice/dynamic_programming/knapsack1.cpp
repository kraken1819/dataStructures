#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)

typedef long long ll;

struct item{
    int weight;
    int value;
    item(int w, int v){
        weight = w;
        value = v;
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, w; 
    cin >> n >> w; 

    vector<item> items;

    rep(i,0,n-1){
        int weight, value; 
        cin >> weight >> value;

        item temp_item(weight, value);
        items.push_back(temp_item);
    }

    ll dp[n+1][w+1] = {};

    rep(i,1,n){
        item cur = items[i-1];
        rep(j,1,w){
            if(j >= cur.weight) dp[i][j] = max(dp[i-1][j], cur.value + dp[i-1][j-cur.weight]);
            else dp[i][j] = dp[i-1][j];
        }
    }

    cout << dp[n][w] << "\n";

}