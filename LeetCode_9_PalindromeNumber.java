public class LeetCode_9_PalindromeNumber {
    public int reverse(int num){
        int sum = 0;
        while(num>0){
            int r = num%10;
            sum = sum*10 + r;
            num/=10;
        }
        return sum;
    }
    public boolean isPalindrome(int x) {
        return x==reverse(x);
    }
}
