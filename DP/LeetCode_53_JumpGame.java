public class LeetCode_53_JumpGame {
    public boolean canJump(int[] nums) {
        int mx = 0;
        for(int i=0; i<nums.length; i++){
            if(mx<i) return false;
            mx = Math.max(mx,i+nums[i]);
        }
        return true;
    }
}
