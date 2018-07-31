import java.util.Scanner;
import java.util.Stack;

/**
 * Leaders in an array
 * print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. The rightmost element is always a leader.
 */
public class LeadersInArray {
    private static Stack leaders(int a[],int n){
        Stack<Integer> st = new Stack<>();
        int currLead = -1;
        for(int i=n-1;i>=0;i--){
            if(a[i] > currLead){
                st.push(a[i]);
                currLead = a[i];
            }
        }
        return st;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[],n;
        Stack<Integer> ans;
        for(int i=0;i<t;i++){
            n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = leaders(a,n);
            while(!ans.isEmpty()) {
                System.out.print(ans.pop() + " ");
            }
            System.out.println();
        }
    }
}
