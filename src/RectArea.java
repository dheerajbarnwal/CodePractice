import java.util.Stack;

/**
 * Created by Dheeraj Kumar Barnwal on 17/04/18.
 * Largest Rectangular Area in a Histogram by Stack
 * Time complexity : O(n)
 */
public class RectArea {
    public static int getMaxArea(int hist[], int n){
        Stack<Integer> st = new Stack<>();
        int i=0;
        int area=0;
        int maxArea=0;
        int count;
        while(i<n){
            if(st.isEmpty() || (hist[i]>=hist[st.peek()])){
                st.push(i++);
            }else{
                int curr = st.pop();
                if(st.isEmpty()){
                    count=i;                //here only right index
                }else{
                    count= i-st.peek()-1;   //count how many element present which is greater that current element both side(left and right)
                }                           //i.e, right-left
                area = hist[curr]*count;
                if(area>maxArea){
                    maxArea = area;
                }
            }
        }
        while(!st.isEmpty()){
            int curr = st.pop();
            if(st.isEmpty()){
                count=i;
            }else{
                count= i-st.peek()-1;
            }
            area = hist[curr]*count;
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    public static void main(String args[]){
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}
