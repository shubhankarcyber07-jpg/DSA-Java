public class LeetCode_4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m+n];

        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                ans[k++] = nums1[i++];
            }
            else ans[k++] = nums2[j++];
        }
        while(i<m) ans[k++] = nums1[i++];
        while(j<n) ans[k++] = nums2[j++];
        if((n+m)%2==1) return ((double) ans[(n+m)/2]);
        else{
            double s = ans[(n+m)/2] + ans[((n+m)/2)-1];
            return s/2;
        }
    }
    // TC: O(m+n)
    // SC: O(m+n)
    // Better approach:
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int total = m + n;

    int i = 0, j = 0;
    int prev = 0, curr = 0;

    for(int k = 0; k <= total / 2; k++){
        prev = curr;

        if(i < m && (j >= n || nums1[i] <= nums2[j])){
            curr = nums1[i++];
        } else {
            curr = nums2[j++];
        }
    }

    if(total % 2 == 1) return curr;
    return (prev + curr) / 2.0;
}
}
