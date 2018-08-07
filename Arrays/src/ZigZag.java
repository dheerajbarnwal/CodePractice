import java.util.Scanner;

/**
 * Convert array into Zig-Zag fashion
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.The relative order of elements is same in the output i.e you have to iterate on the original array only.
 */
public class ZigZag {
    private static void swap(int a[],int i){
        int temp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = temp;
    }
    private static void createZigZag(int a[],int n){
        boolean flag =false;
        for(int i=0;i<n-1;i++) {
            if(flag == true && a[i]<a[i+1]) {
                swap(a,i);
            }
            else if(flag == false && a[i]>a[i+1]) {
                swap(a,i);
            }
            flag = !flag;
        }
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
            createZigZag(a,n);
            for(int k=0;k<n;k++){
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }
}
