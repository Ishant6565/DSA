class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int rev = 0;

        while (x != 0) {
            int r = x % 10;
            rev = rev * 10 + r;
            x = x / 10;
        }

        return rev == original;
    }
}

