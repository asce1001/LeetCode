class Solution {
    public int search(ArrayReader r1, int target) {
        int low = 0;
        int high = 1;
        while (r1.get(high) < target) {
            low = high;
            high = high * 2;
        }
        while(low<=high) {
            int mid = low + (high - low)/2;
            int temp = r1[mid];
            if (target == r1[mid])  {
                return mid;
            } else if (target > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
