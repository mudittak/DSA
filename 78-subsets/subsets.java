class Solution {
    private void subsets(List<Integer> ans, int[] nums, int idx, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(ans)); // add current subset
            return;
        }
        int num = nums[idx];
        
        // pick
        ans.add(num);
        subsets(ans, nums, idx + 1, list);
        ans.remove(ans.size() - 1); // backtrack
        
        // skip
        subsets(ans, nums, idx + 1, list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(new ArrayList<>(), nums, 0, list);
        return list;
    }
}
