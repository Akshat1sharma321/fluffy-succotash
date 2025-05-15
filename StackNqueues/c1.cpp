#include <bits/stdc++.h> 
using namespace std ; 
vector<int> nextLargerElement(vector<int>& arr) {
        // code here
        int n = arr.size() ; 
        vector<int>nge(n) ; 
        stack<int>st ; 
        for(int i = 0 ; i < arr.size() ; i++){
          while(st.size()!=0 && arr[i]<arr[st.top()]){
              int idx = st.top() ;  
              nge[idx] = arr[i] ; 
              st.pop() ; 
          }  
          st.push(i) ; 
        }
        while(st.size()!=0){
           int idx = st.top() ; 
           nge[idx] = -1 ; 
           st.pop();
        }
        return nge ; 
    }
    vector<int> leftSmaller(vector<int> arr) {
        // code here
        int n = arr.size() ; 
        vector<int>nge(n) ; 
        stack<int>st ; 
        for(int i = 0 ; i < arr.size() ; i++){
          while(st.size()!=0 && arr[i]<=st.top()){
              st.pop() ; 
          }  
          if(st.size()==0){
              nge[i]=-1;
          }
          else{
              nge[i]=st.top() ; 
          }
          st.push(arr[i]) ; 
        }
        
        return nge ; 
    }
    
int main(){
    // cout<<2412214;
    vector<int>arr = {2,2,3,4,44,55,77,1} ; 
    vector<int> abc = nextLargerElement(arr);
    for(auto i : abc){
        cout<<i<<" " ; 
        // cout<<endl ;
    }
    return  0 ; 
}