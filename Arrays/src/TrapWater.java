import java.util.Scanner;

/**
 * Trapping Rain Water
 * Given n non-negative integers in array representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */
public class TrapWater {
    private static int trap(int a[],int n){
        int ans=0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0]=a[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],a[i]);
        }
        right[n-1]=a[n-1];
        for(int i =n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],a[i]);
        }
        for(int i=0;i<n;i++){
            ans+=Math.min(left[i],right[i]) - a[i];
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
            ans = trap(a,n);
            System.out.println(ans);
        }
    }
}
