import java.util.*;
public class class3 {
    public static long solve(int N, int[] A, int K) {
        long lo = 0, hi = (long) 2e9, ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            boolean ok = false;
            for (int i = 1; i <= N - 2; i++) {
                long cost = Math.max(0, mid - A[i])
                        + Math.max(0, A[i - 1] - (mid - 1))
                        + Math.max(0, A[i + 1] - (mid - 1));
                if (cost <= K) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                ans = mid;
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return ans;
    }
    public static long solve2(int N, int M, int[] A, int[][] edges){
    int[] parent = new int[N];
    int[] size = new int[N];
    for(int i=0;i<N;i++){
        parent[i]=i;
        size[i]=1;
    }
    for(int i=0;i<M;i++){
        int u = edges[i][0];
        int v = edges[i][1];
        u--; v--;
        int pu=u, pv=v;
        while(parent[pu]!=pu) pu=parent[pu];
        while(parent[pv]!=pv) pv=parent[pv];
        if(pu!=pv){
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
    int[] compSize = new int[N];
    for(int i=0;i<N;i++){
        int p=i;
        while(parent[p]!=p) p=parent[p];
        compSize[i]=size[p];
    }
    int[] degree = new int[N];
    for(int i=0;i<M;i++){
        int u = edges[i][0]-1;
        int v = edges[i][1]-1;
        degree[u]++;
        degree[v]++;
    }
    long[] score = new long[N];
    for(int i=0;i<N;i++){
        score[i]=degree[i]+compSize[i];
    }
    Arrays.sort(A);
    Arrays.sort(score);
    long ans=0;
    for(int i=0;i<N;i++){
        ans += score[i]*A[i];
    }
    return ans;
}
    public static void main(String[] args) {
    //     System.out.println("Testing");
    //     int num = 1 ;
        
    //    while(num<=5){
    //     System.out.println(num++);
    //    }
    // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the numbers : ");
        // for(int i = 0 ; i < 5 ; i++){
        //     int x = sc.nextInt();
        //     if(x%2==0){
        //         System.out.println("Even");
        //     }
        //     else{
        //         System.out.println("odd");
        //     }
        // }
    //     System.out.println("Enter the number for the Table to be displayed");
    //     Scanner sc = new Scanner(System.in);
    //     int x = sc.nextInt();

    // for(int i = 1 ; i <= 10 ; i++){
    //     System.out.println(x*i);
    // }

    //         int fact = 1 ;
//       while(i>0){
//         fact = fact*i;
//         i--;
//       }
// System.out.println(fact);
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the number for num");
// int x = sc.nextInt();
System.out.println(solve(3, new int[]{1,5,2}, 0));

// if(x==2){
//     System.out.println("prime");
// }


// for(int i = 1 ; i <= x ; i++){

// int flag = 0 ;  
//     for(int j = 2 ; j*j<=i ; j++){
//     if(x%j==0){
//         flag=1;
//         System.out.println(i + " not prime");
//         break;
//     }
// }

// if(flag==0){
//     System.out.println(i+ "prime");
// }


// }

    }
}