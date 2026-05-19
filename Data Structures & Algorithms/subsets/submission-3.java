class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, List<List<Integer>>> memo = new HashMap<>();
        backtrack(nums, 0, new ArrayList<>(), result, memo);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result, Map<String, List<List<Integer>>> memo) {
        String key = start + "-" + current.toString();
        if (memo.containsKey(key)) {
            result.addAll(memo.get(key));
            return;
        }
        
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result, memo);
            current.remove(current.size() - 1);
        }
        
        memo.put(key, new ArrayList<>(result));
    }
}
