public class LeetCode_53_MaximumSubarray {
     public int maxSubArray(int[] arr){
        int sum = arr[0];
        int max = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for(int i = 1; i < arr.length; i++){

            if(arr[i] > sum + arr[i]){
                sum = arr[i];
                tempStart = i; // restart
            } else {
                sum = sum + arr[i];
            }

            if(sum > max){
                max = sum;
                start = tempStart;
                end = i;
            }
        }

        // print result
        System.out.println("Max Sum: " + max);
        System.out.print("Subarray: ");
        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + " ");
        }
        return max;
    }
    // public int maxSubArray(int[] arr) {
    //     int n = arr.length;
    //     for(int i=1; i<n; i++){
    //         arr[i] = arr[i] + arr[i-1];
    //     }

    //     int[][] dp = new int[n][n];
    //     int max = arr[0];

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(i==0){
    //                 dp[i][j] = arr[j];
    //                 max = Math.max(max,dp[i][j]);
    //             }
    //             else if(i<=j){
    //                 dp[i][j] = arr[j] - arr[i-1];
    //                 max = Math.max(max,dp[i][j]);
    //             }
    //         }
    //     }
    //     return max;
    // }
}
