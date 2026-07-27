class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] needFreq = new int[128];
        int[] windowFreq = new int[128];

        // Store frequency of characters required from t
        for (int i = 0; i < t.length(); i++) {
            needFreq[t.charAt(i)]++;
        }

        int left = 0;
        int count = 0;          // number of satisfied unique characters
        int required = 0;       // total unique characters in t

        for (int i = 0; i < 128; i++) {
            if (needFreq[i] > 0) {
                required++;
            }
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Sliding window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character into window
            windowFreq[ch]++;

            // If this character requirement is satisfied
            if (needFreq[ch] > 0 && 
                windowFreq[ch] == needFreq[ch]) {
                count++;
            }

            // Window is valid, try shrinking
            while (count == required) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                windowFreq[leftChar]--;

                // If removing breaks requirement
                if (needFreq[leftChar] > 0 &&
                    windowFreq[leftChar] < needFreq[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE  ? "" : s.substring(start, start + minLen);
    }
}