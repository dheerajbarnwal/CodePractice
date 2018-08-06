import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Pythagorean Triplet
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 */
public class PythgoreanTriplet {
    private static String isExist(int a[],int n){
        String ans="No";
        Set<Integer> s =new HashSet<>();
        for(int i=0;i<n;i++){
            a[i] = a[i]*a[i];
            s.add(a[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i){
                    continue;
                }
                if(s.contains(a[i]-a[j])==true){
                    ans = "Yes";
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        String ans;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = isExist(a,n);
            System.out.println(ans);
        }
    }
}
