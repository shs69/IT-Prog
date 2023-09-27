package Labs;

public class Palindrome {
        public static void main(String[] args) {
            for (int i = 0; i < args.length; i++) {
                String s = args[i];
                System.out.print(s + ' ' + reverseString(s) + ' ');
                System.out.println(isPalindrome(s));
            }
        }

        public static String reverseString(String s) {
            String newS = "";
            char ch;
            for (int i = s.length() - 1; i >= 0; i--) {
                ch = s.charAt(i);
                newS += ch;
            }
            return newS;
        }

        public static boolean isPalindrome (String S) {
            return reverseString(S).equals(S);
        }
    }

