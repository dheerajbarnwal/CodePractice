import java.util.Scanner;

/**
 * Find the element that appears once in sorted array (logn solution)
 * Given a sorted array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.
 */
public class AppearOnce {
    private static int find(int a[],int l,int r){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(l==r){
                return a[l];
            }
            if(mid%2==0){
                if(a[mid]==a[mid+1]){
                    l=mid+2;
                }else{
                    r=mid;
                }

            }else{
                if(a[mid]==a[mid-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ans;
        int a[];
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = find(a,0,n-1);
            System.out.println(ans);
        }
    }
}
