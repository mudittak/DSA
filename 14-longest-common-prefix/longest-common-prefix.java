class Solution {
    public String longestCommonPrefix(String[] strs) {

        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {

                // Current string is shorter
                if (i >= strs[j].length()) {
                    return first.substring(0, i);
                }

                // Character mismatch
                if (strs[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }
}