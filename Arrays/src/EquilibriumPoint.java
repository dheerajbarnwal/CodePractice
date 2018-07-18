import java.util.Scanner;

/**
 * Equilibrium point
 * Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.
 */
public class EquilibriumPoint {
    private static int equilibriumPoint(int a[],int n){
        int totalSum=0,currentSum=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            totalSum+=a[i];
        }
        for(int i=0;i<n;i++){
            if(currentSum==totalSum-(a[i]+currentSum)){
                ans = i+1;
            }
            currentSum+=a[i];
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
            ans = equilibriumPoint(a,n);
            System.out.println(ans);
        }
    }
}
