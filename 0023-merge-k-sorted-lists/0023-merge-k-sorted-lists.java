/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->(a.val-b.val));
        ListNode ans = null;
        ListNode root=null;
        for(int k=0;k<lists.length;k++){
            if(lists[k]==null){
                continue;
            }
            pq.add(lists[k]);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            if(ans==null){
                ans = temp;
                root = ans;
            }else{
                ans.next = temp;
                ans = ans.next;
            }
            
            
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        return root;
        
    }
}