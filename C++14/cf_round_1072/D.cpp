#include <bits/stdc++.h>
using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll; 

long long combinations(int n, int r) {
    if (r < 0 || r > n) return 0;
    if (r == 0 || r == n) return 1;
    if (r > n / 2) r = n - r;
    long long res = 1;
    for (int i = 1; i <= r; ++i) {
        res = res * (n - i + 1) / i;
    }
    return res;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc; cin >> tc; 

    while(tc--){
        int n, k; 
        cin >> n >> k; 

        int tempn = n;
        int pow = log2(n);

        int max_possible_power = min(pow-1, k-1);

        int solvable_numbers = 0; 

        int moves_left = (k-1) > pow ? k-1-pow : 0; 

        cout << pow << " " << max_possible_power << " " << moves_left << "\n";

        n /= 2; 
        while(n){
            
            rep(i,0,min(pow,moves_left)){
                solvable_numbers += combinations(pow,i);
            }
            n/=2;
            pow--;
            moves_left++;
        }

        cout << tempn - solvable_numbers << "\n";
    }
    
}