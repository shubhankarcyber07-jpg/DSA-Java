public class LeetCode_45_JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int i = 0;
        int count = 0;

        while(i < n - 1){

            if(i + nums[i] >= n - 1) return count + 1;

            int max = -1, maxIndex = -1;

            for(int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++){
                if(j + nums[j] > max){
                    max = j + nums[j];
                    maxIndex = j;
                }
            }

            i = maxIndex;
            count++;
        }

        return count;
    }
}
