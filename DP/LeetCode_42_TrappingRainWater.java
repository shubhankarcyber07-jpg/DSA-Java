
public class LeetCode_42_TrappingRainWater {
    // Two pointer
    public int trap(int[] height) {
        int n = height.length;
        if(n==0) return 0;
        int i = 0, j=n-1;
        int lmax = height[i], rmax = height[j];
        int res=0;
        while(i<j){
            if(lmax <= rmax){
                i+=1;
                lmax = Math.max(lmax,height[i]);
                if(lmax-height[i]>0) res+=lmax-height[i];
            }
            else{
                j-=1;
                rmax = Math.max(rmax,height[j]);
                if(rmax-height[j]>0) res+=rmax-height[j];
            }
        }
        return res;
    }

    //using Max heep
    // public int trap(int[] height) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //     int n = height.length;
    //     for(int i=1; i<n; i++){
    //         pq.add(height[i]);
    //     }
    //     int max = height[0];
    //     int sum = 0;
    //     for(int i=1; i<n-1; i++){
    //         int min = Math.min(max,pq.peek());
    //         if(min<=height[i]) sum+=0;
    //         else{
    //             sum += (min-height[i]);
    //         }
    //         max = Math.max(max,height[i]);
    //         pq.remove(height[i]);
    //     }
    //     return sum;
    // }
}
