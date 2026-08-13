import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Rightmost element का NGE हमेशा -1 होगा
        nge[n - 1] = -1;
        st.push(nums2[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(nums2[i]);
        }

        // अब nums1 के लिए result बनाओ
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // nums2 में nums1[i] का index ढूँढो
            for (int j = 0; j < n; j++) {
                if (nums2[j] == nums1[i]) {
                    ans[i] = nge[j];
                    break;
                }
            }
        }
        return ans;
    }
}
