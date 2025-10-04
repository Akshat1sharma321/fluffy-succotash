#define _CRT_SECURE_NO_WARNINGS
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
/***from dust i have come, dust i will be***/
#include <iostream>
#include <algorithm>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <functional>
#include <iomanip>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <utility>
#include <vector>
#include <climits>

typedef long long int ll;
typedef unsigned long long int ull;

#define dbg printf("in\n")
#define nl printf("\n");
#define N 610
#define pp pair<int, int>
// #define inf 10000000
// #define ll long long
#define scl(n) scanf("%lld", &n)
#define scll(n, m) scanf("%lld%lld", &n, &m)
#define scc(c) scanf("%c", &c)
#define fr(i, n) for (ll i = 0; i < n; i++)
#define fr1(i, n) for (ll i = 1; i <= n; i++)
#define pfl(x) printf("%lld\n", x)
#define pb push_back
#define debug cout << "I am here" << endl;
#define pno cout << "NO" << endl
#define pys cout << "YES" << endl
#define tcas(i, t) for (ll i = 1; i <= t; i++)

#define l(s) s.size()
#define asort(a) sort(a, a + n)
#define all(x) (x).begin(), (x).end()
#define dsort(a) sort(a, a + n, greater<int>())
#define vasort(v) sort(v.begin(), v.end());
#define vdsort(v) sort(v.begin(), v.end(), greater<int>());
#define uniquee(x) x.erase(unique(x.begin(), x.end()), x.end())
#define pn printf("\n")
#define el cout << endl
#define md 1000000007
#define inf 9e18
#define ps cout << " ";
#define Pai acos(-1.0)
#define pr pair<ll, ll>
#define ff first
#define ss second
#define mem(a, i) memset(a, i, sizeof(a))
#define pcas(i) cout << "Case " << i << ": " << endl;

using namespace std;

long long combi(long long n, vector<long long> &dp)
{
    // if(n<=0)return 1 ;
    // if(dp[n]!=-1) return dp[n] ;
    long long arr[] = {1, 2, 3, 4, 5, 6};
    // long long ways =  0 ;
    // for(int i : arr){
    // if(n - i >= 0)
    // ways += combi(n - i , dp) ;
    // }
    // return  dp[n] = ways ;
    long long mod = (int)1e9 + 7;
    for (int i = 0; i <= n; i++)
    {
        long long ways = 0;
        if (i == 0)
        {
            dp[i] = 1;
            continue;
        }
        for (int no : arr)
        {
            if (i - no >= 0)
            {
                ways = (ways + dp[i - no]) % mod;
            }
        }
        dp[i] = ways;
    }
    return dp[n];
};
int main()
{
    // ll n , tar_x , tar_y ;
    // scl(n) ;
    // string s  ;
    // cin>>s ;
    // scll(tar_x,tar_y) ;
    // vector<ll>px(n+1,0),py(n+1,0) ;
    // fr(i,n){
    //     px[i+1] = px[i] ;
    //     py[i+1] = py[i] ;
    //     if(s[i]=='R') px[i+1]++ ;
    //     else if(s[i]=='L') px[i+1]-- ;
    //     else if(s[i]=='U')py[i+1]++ ;
    //     else py[i+1]--;
    // }

    // if(px[n]==tar_x && py[n]==tar_y) {cout<<0<<endl ; return 0 ; }

    // ll ans = n + 1 ;
    // ll l= 0 ;
    // for(int r = 0 ; r < n ; ++r){
    //     while(l<=r){
    //     ll    len = r - l + 1 ;
    //         ll curr_x = px[l] + (px[n] - px[r+1]) ;
    //         ll curr_y = py[l] + (py[n] - py[r+1]) ;
    //         if(check()){
    //             ans = min(len,ans) ;
    //             l++ ;
    //         }
    //         else{
    //             break ;
    //         }
    //     }
    // }
    long long n;
    cin >> n;
    vector<long long> dp(n + 1, -1);
    cout << combi(n, dp);
}