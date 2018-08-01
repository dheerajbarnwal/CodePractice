import java.util.*;

/**
 * Maximum of all subarrays of size k
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 */
public class MaxOfSubK {
    private static int[] slidingWindow(int a[], int n,int k){
        int res[] = new int[n-k+1];
        int in=0;
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        /* Process first k (or first window) elements of array */
        for(i = 0; i < k; ++i)
        {
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while(!Qi.isEmpty() && a[i] >= a[Qi.peekLast()])
                Qi.removeLast();

            Qi.addLast(i);
        }

        for( ;i < n; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so take it
            res[in++] = a[Qi.peek()];
            // Remove the element which is out of this window
            if(Qi.peek() == i-k)
                Qi.removeFirst();

            while((!Qi.isEmpty()) && a[i] >= a[Qi.peekLast()])
                Qi.removeLast();

            Qi.addLast(i);

        }
        // take the maximum element of last window
        res[in++] = a[Qi.peek()];
        return res;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[],n,k;
        int ans[];
        for(int i=0;i<t;i++){
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            ans = slidingWindow(a,n,k);

            for(int j = 0;j<n-k+1;j++){
                System.out.print(ans[j] + " ");
            }

            System.out.println();
        }
    }
}
