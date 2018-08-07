import java.util.Scanner;

/**
 * Element with left side smaller and right side greater
 * Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 * Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
 */
public class FirstLeader {
    private static int getFirst(int a[],int n){
        int temp[] = new int[n];
        int ans = -1;
        int leftMax = a[0];
        for(int i=1;i<n;i++){
            temp[i] = leftMax;
            if(a[i]>leftMax){
                leftMax = a[i];
            }
        }
        int rightMin = a[n-1];
        for(int i=n-2;i>0;i--){
            if(a[i]>=temp[i] && a[i]<=rightMin){
                ans = a[i];
            }
            if(a[i]<rightMin){
                rightMin=a[i];
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
            ans = getFirst(a,n);
            System.out.println(ans);
        }
    }
}
