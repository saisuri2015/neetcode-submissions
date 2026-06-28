class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        StringBuilder strBuild = new StringBuilder();
        int maxIndex = Integer.MAX_VALUE;
        for (String str : strs) maxIndex = Math.min(maxIndex, str.length());
        int index = 0;
        for (index = 0; index < maxIndex; index++) {
            for (int i = 1; i < strs.length; i++) {
                String previous = strs[i - 1], current = strs[i];
                if (current.charAt(index) != previous.charAt(index)) return current.substring(0, index);
            }
        }
        return strs[0].substring(0, index);
    }
}