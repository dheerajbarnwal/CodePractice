import java.util.Scanner;

/**
 *Longest Increasing Subsequence (nlogn solution)
 */
public class LongestIncSub {
    static int al[] = new int[1005];
    static int len;
    public static int find(int num, int low, int high){
        if(num>al[high]){
            len++;
            return len;
        }else if(num<al[1]){
            return 1;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(al[mid] == num){
                return -1;
            }else if(num<al[mid] && num > al[mid-1]){
                return mid;
            }else if(num>al[mid]){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int arr[];
        for(int t=0;t<T;t++){
            int n = sc.nextInt();
            if(n==0){
                System.out.println("0");
                continue;
            }
            arr = new int[n];
            len=1;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            al[1]=arr[0];
            for(int i=1;i<n;i++){
                int index = find(arr[i],2,len);
                if(index!=-1)
                    al[index] = arr[i];
            }
            System.out.println(len);
        }
    }
}
