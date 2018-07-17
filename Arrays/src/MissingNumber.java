import java.util.Scanner;

/**
 * Missing number in array
 * Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.
 */
public class MissingNumber {
    private static int missingNum(int a[], int n){
        int xorSum = 0;
        for(int i=1;i<=n;i++){
            xorSum^=i;
        }
        for(int i=0;i<n-1;i++){
            xorSum^=a[i];
        }
        return xorSum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        int ans;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n-1;j++){
                a[j] = sc.nextInt();
            }
            ans = missingNum(a,n);
            System.out.println(ans);
        }
    }
}
