import java.util.Scanner;

/**
 * Sort an array of 0s, 1s and 2s
 * Write a program to sort an array of 0's,1's and 2's in ascending order.
 */
public class SortZOT {
    private static void sortArray(int a[],int n){
        int l=0,m=0,r=n-1;
        while(m<=r){
            if(a[m]==0){
                int temp = a[l];
                a[l] = a[m];
                a[m] = temp;
                l++;
                m++;
            }
            else if(a[m]==2){
                int temp = a[r];
                a[r] = a[m];
                a[m] = temp;
                r--;
            }
            else if(a[m]==1){
                m++;
            }

        }
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            sortArray(a,n);
        }
    }
}
