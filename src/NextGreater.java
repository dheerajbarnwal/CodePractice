import java.util.Stack;

/**
 * Created by Dheeraj Kumar Barnwal on 18/04/18.
 * Given an array, print the Next Greater Element (NGE) for every element.
 */
public class NextGreater {
    public static void printNGE(int arr[],int n){
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i]=-1;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                res[st.pop()] =arr[i];
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i] + "--->" + res[i]);
        }
    }
    public static void main(String args[]){
        int arr[] = { 5,3,2,11, 9,8, 10, 13 };
        int n = arr.length;

        printNGE(arr, n);
    }
}
