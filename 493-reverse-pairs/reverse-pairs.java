class Solution {
    static int count;

    // Count inversions (reverse pairs condition)
    public void inversion(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if ((long) a[i] > (2L * (long) b[j])) {
                count += (a.length - i);
                j++;
            } else {
                i++;
            }
        }
    }

    // Merge two sorted arrays into one
    public void merge(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while (j < b.length) c[k++] = b[j++];
        while (i < a.length) c[k++] = a[i++];
    }

    // Merge sort with inversion counting
    public void mergesort(int[] arr) {
        int n = arr.length;
        if (n == 1) return; // base case

        // Split into two halves
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) a[i] = arr[i];
        for (int i = n / 2; i < n; i++) b[i - n / 2] = arr[i];

        // Recursive sort
        mergesort(a);
        mergesort(b);

        // Count reverse pairs between halves
        inversion(a, b);

        // Merge sorted halves back
        merge(a, b, arr);

        // Free memory
        a = null;
        b = null;
    }

    // Main function to call
    public int reversePairs(int[] nums) {
        count = 0;
        mergesort(nums);
        return count;
    }
}
