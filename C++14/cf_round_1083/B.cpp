#include <bits/stdc++.h>
using namespace std; 

#define rep(i,a,b) for(int i=a;i<=b;i++)
#define drep(i,a,b) for(int i=a;i>=b;i--)

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tc; cin >> tc; 
    while(tc--){
        int n; cin >> n; 

        int result = 1; 

        // for even num
        if(!(n&1)){
            result *= 2; 
            while(!(n&1)){
                n /= 2; 
            }
        }

        //for odd num

        for(int i= 3; i * i <= n; i+=2){
            if(n % i == 0){
                result *= i; 
                while(n % i == 0)
                    n /= i;
            }
        }

        if( n > 1 )
            result *= n; 

        cout << result << "\n"; 

    }
}