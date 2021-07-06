public class Leet415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length(), len2 = num2.length();
            int i = len1 - 1, j = len2 - 1, carry = 0;
            StringBuilder sb = new StringBuilder();

            while (i >= 0 || j >= 0 || carry != 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = n1 + n2 + carry;

                carry = sum / 10;
                sb.append(sum % 10);
                i--;
                j--;
            }
            return sb.reverse().toString();
        }
    }
}
