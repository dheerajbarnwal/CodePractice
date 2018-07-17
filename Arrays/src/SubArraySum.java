import java.util.*;

/**
 * Subarray with given sum
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 */
public class SubArraySum {

    private static void subArray(int a[],int n,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        int currentSum=0;
        map.put(currentSum,0);
        int start=-1,end=-1;
        for(int i=0;i<n;i++){
            currentSum+=a[i];
            map.put(currentSum,i+1);
            if(currentSum>=sum && map.containsKey(currentSum-sum)==true ){
                start = map.get(currentSum - sum);
                end=i;
                break;
            }
        }
        if(end==-1){
            System.out.println("-1");
            return;
        }
        System.out.println((start+1) + " " + (end+1));
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int sum = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            subArray(a,n,sum);
        }

    }
}
