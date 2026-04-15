import java.util.*;
public class LeetCode_22_GenerateParentheses {
    // public void generate(int i, int j, List<String> ans, String s){
    //     if(i == 0 && j == 0){
    //         ans.add(s);
    //         return;
    //     }
    //     if(i > 0) generate(i - 1, j, ans, s+"(");
    //     if(j > 0 && j > i) generate(i, j - 1, ans, s+")");  
    // }

    // public List<String> generateParenthesis(int n) {
    //     List<String> ans = new ArrayList<>();
    //     generate(n, n, ans, "");
    //     return ans;
    // }
    public void generate(int i, int j, List<String> ans, StringBuilder sb){
        
        if(i == 0 && j == 0){
            ans.add(sb.toString());
            return;
        }

        // add '('
        if(i > 0){
            sb.append('(');                 // choose
            generate(i - 1, j, ans, sb);    // explore
            sb.deleteCharAt(sb.length()-1); // undo (backtrack)
        }

        // add ')'
        if(j > 0 && j > i){
            sb.append(')');                 // choose
            generate(i, j - 1, ans, sb);    // explore
            sb.deleteCharAt(sb.length()-1); // undo
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, n, ans, new StringBuilder());
        return ans;
    }
}