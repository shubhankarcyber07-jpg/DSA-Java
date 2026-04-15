class Solution {
    // Two pass
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else right++;

            if(left == right){
                max = Math.max(max, 2 * right);
            }
            else if(right > left){
                left = right = 0;
            }
        }

        left = right = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '(') left++;
            else right++;

            if(left == right){
                max = Math.max(max, 2 * left);
            }
            else if(left > right){
                left = right = 0;
            }
        }

        return max;
    }

    //stack
    // public int longestValidParentheses(String s) {
    //     Stack<Integer> stack = new Stack<>();
    //     stack.push(-1); // base

    //     int max = 0;

    //     for(int i = 0; i < s.length(); i++){

    //         if(s.charAt(i) == '('){
    //             stack.push(i);
    //         } 
    //         else{
    //             stack.pop();

    //             if(stack.isEmpty()){
    //                 stack.push(i); // reset base
    //             } 
    //             else{
    //                 max = Math.max(max, i - stack.peek());
    //             }
    //         }
    //     }

    //     return max;
    // }
}