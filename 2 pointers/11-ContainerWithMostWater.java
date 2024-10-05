class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            System.out.print(right);
            System.out.print(left);
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
