#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
using namespace std;
int main(){
    unordered_map<string,int>mpp ; 
    mpp["India"] = 143 ; 
    mpp["china"] = 140 ; 
    mpp["France"] = 30 ; 
    for(auto it  : mpp){
        cout<<it.first<<" "<<it.second ; 
    }
    cout<<mpp["India"] ; 
    if (mpp.find("China")==mpp.end())cout<<"No val" ; 
}