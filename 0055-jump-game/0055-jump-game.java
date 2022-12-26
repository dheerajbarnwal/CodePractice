class Solution {

    public boolean canJump(int[] nums) {
        //return canJump1(nums);
        return canJump2(nums);
    }

    boolean canJump1(int[] nums) {
        int n = nums.length;
        int target = n - 1;

        while (target != 0) {
            int start = target - 1;
            while (start >= 0 && start + nums[start] < target) {
                start--;
            }

            if (start < 0 && target != 0) {
                return false;
            }

            target = start;
        }
        return true;
    }

    boolean canJump2(int[] nums) {
        int n = nums.length;
        int reach=0;
        for(int i=0;i<=reach;i++){
            reach=Math.max(reach,i+nums[i]);
            if(reach>=n-1){
                return true;
            }
        }
        return false;
    }
}
