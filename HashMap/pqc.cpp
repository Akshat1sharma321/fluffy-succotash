#include<iostream>
#include<queue>
using namespace std ; 
int main(){
    priority_queue<int>pq ; 
    pq.push(10) ; 
    pq.push(23) ; 
    cout<<pq.top() ;
    priority_queue<int,vector<int>,greater<int>>mpq ;
    mpq.push(10);
    mpq.push(23);
    cout << mpq.top();
}

class MedianFinder
{
    priority_queue<int,vector<int>,greater<int>> minpq;
    priority_queue<int> maxpq;

public :
    MedianFinder()
    {
        
    }

public :
    void addNum(int num){
        if (maxpq.size() == 0 || num <= maxpq.top())
            maxpq.push(num);
        else
            minpq.push(num);

        int ls = maxpq.size();
        int rs = minpq.size();
        if (rs > ls)
        {
            int n = minpq.top() ;
                        maxpq.push(n);
        }
        else if (ls - rs > 1)
        {
            int n = maxpq.top() ;
            minpq.push(n);
        }
    }

public :
    double findMedian()
    {
        int ls = maxpq.size();
        int rs = minpq.size();
        double mid = 0;
        if (ls == rs)
        {
            mid = maxpq.top() + minpq.top() ; 
        }
        else if (ls - rs == 1)
        {
            return maxpq.top();
        }
        return mid / 2;
    } 
} ;