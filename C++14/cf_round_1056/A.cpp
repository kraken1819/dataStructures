#include <bits/stdc++.h>

using namespace std;

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc; cin >> tc;
    while(tc--){
        int n; cin >> n; 
        int win_grp_count = n; 
        int lsr_grp_count = 0; 
        int game_count = 0;
        while(win_grp_count != 1 || lsr_grp_count != 1){
            game_count += win_grp_count/2;
            if(lsr_grp_count != 0) game_count += lsr_grp_count/2;

            int temp = win_grp_count/2;
            win_grp_count -= temp;
            lsr_grp_count -= lsr_grp_count/2; 
            lsr_grp_count += temp;
        }
        cout << game_count + 1 << "\n";
    }
}