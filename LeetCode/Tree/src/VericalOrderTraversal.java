import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 *
 * Note:
 * 1) first sort it with horizontal distance
 -- here used TreeMap to solve this
 2) then sort it with from UP to Down for same horizonatal distance
 __ here used 'Y' to solve this with is increasing by 1 always because using DFS

 3) if Y is same, means on same position then sort it with node value.
 -- here used 'val' to solve this.

 Check: MyComp class for custom sorting
 */



//  Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
 }
class CustInt{
    int val;
    int y;
    public CustInt(int val, int y){
        this.val = val;
        this.y=y;
    }
}
class myComp implements Comparator<CustInt> {

    public int compare(CustInt a, CustInt b){
        if(a.y==b.y){
            return a.val-b.val;
        }else{
            return a.y-b.y;
        }
    }
}
class VericalOrderTraversal {
    Map<Integer,List<CustInt>> hm = new TreeMap<>();

    public void verticalTraversal(TreeNode root, int i,int j) {
        if(hm.containsKey(i)){
            hm.get(i).add(new CustInt(root.val,j));
        }else{
            List<CustInt> l = new ArrayList<>();
            l.add(new CustInt(root.val,j));
            hm.put(i,l);
        }
        if(root.left!=null){
            verticalTraversal(root.left,i-1,j+1);
        }
        if(root.right!=null){
            verticalTraversal(root.right,i+1,j+1);
        }

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        verticalTraversal(root,0,0);
        for(List<CustInt> val:hm.values()){
            Collections.sort(val, new myComp());
            List<Integer> l = new ArrayList<>();
            for(CustInt ci : val){
                l.add(ci.val);
            }
            ans.add(l);
        }
        return ans;
    }

}
