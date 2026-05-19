class Solution {
    ArrayList<List<Integer>> result = new ArrayList<>();
    public void findsubsets(int[] nums, int index, ArrayList<Integer> temp, int sum) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            findsubsets(nums, i + 1, temp, sum - i);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        findsubsets(nums, 0, new ArrayList<Integer>(), 5);
        return result;
    }
}