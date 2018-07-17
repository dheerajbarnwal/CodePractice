import java.util.Scanner;

/**
 * Kadane’s Algorithm
 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 */
public class Kadane {
    public static int maxSum(int a[],int n){
        int currentSum=0,ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currentSum+=a[i];
            if(currentSum>ans){
                ans = currentSum;
            }
            if(currentSum<0){
                currentSum = 0;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        int ans;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = maxSum(a,n);
            System.out.println(ans);
        }

    }
}
