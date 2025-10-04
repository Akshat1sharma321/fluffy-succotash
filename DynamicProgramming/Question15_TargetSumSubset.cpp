#include <bits/stdc++.h> 
using namespace std  ; 
bool subset(vector<int> &arr, int sum, int idx, vector<vector<int>> &dp)
{
    if (sum == 0 || idx == arr.size())
    {
        return sum == 0 ? true : false;
    }
    bool isPos = false;
    if (dp[idx][sum] != -1)
        return dp[idx][sum];
    if (sum - arr[idx] >= 0)
    {
        isPos = subset(arr, sum - arr[idx], idx + 1, dp);
    }
    dp[idx][sum] = isPos || subset(arr, sum, idx + 1, dp);
    return dp[idx][sum];
}