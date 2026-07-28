class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] c = new int[m + n];
        mergeArrays(nums1, m, nums2, n, c);

        
        for (int i = 0; i < c.length; i++) {
            nums1[i] = c[i];
        }
    }

    
    public static void mergeArrays(int[] a, int m, int[] b, int n, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while (i < m) c[k++] = a[i++];
        while (j < n) c[k++] = b[j++];
    }
}
