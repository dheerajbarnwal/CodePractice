import java.util.*;

/**
 * Stock buy and sell
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 */
public class StockTransaction {
    class Data{
        int buy;
        int sell;
        Data(int b,int s){
            buy=b;
            sell=s;
        }
    }
    private void printTransaction(int a[],int n){
        Stack<Data> ans = new Stack<>();
        int b,s,flag=0;
        for(int i=n-1;i>0;i--){
            s =i;
            while(i>=1 && a[i-1]<a[i]){
                i--;
                flag=1;
            }
            if(i>=0 && flag==1){
                b=i;
                ans.push(new Data(b,s));
                flag=0;
            }
        }
        if(ans.isEmpty()){
            System.out.println("No Profit");
            return;
        }
        while(!ans.isEmpty()){
            Data d =ans.pop();
            System.out.print("("+d.buy +" "+d.sell+") ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StockTransaction st = new StockTransaction();
        int t = sc.nextInt();
        int a[];
        int ans;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            st.printTransaction(a,n);
        }
    }
}
