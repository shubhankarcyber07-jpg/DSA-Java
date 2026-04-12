public class LeetCode_8_StringTOInteger {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. skip spaces
        while(i < n && s.charAt(i) == ' ') i++;

        // 2. sign
        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }

        // 3. build number
        int result = 0;

        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            // 4. overflow check
            if(result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
