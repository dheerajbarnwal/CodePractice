import java.util.Scanner;

/**
 * Maximum sum increasing subsequence
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order.
 */
public class MaxSumIncSub {
    private static int maxSumInc(int a[],int n){
        int res[] = new int[n];
        res=a.clone();
        int ans = a[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && res[i]<a[i]+res[j]){
                    res[i] = a[i]+res[j];
                }
            }
            if(res[i]>ans){
                ans=res[i];
            }
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[],n,ans;
        for(int i=0;i<t;i++){
            ans = 0;
            n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = maxSumInc(a,n);
            System.out.println(ans);
        }
    }
}
