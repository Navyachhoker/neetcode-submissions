/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // Find peak
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                l = mid + 1;
            else
                r = mid;
        }

        int peak = l;

        // Search left (ascending)
        int ans = binarySearch(mountainArr, target, 0, peak, true);

        if (ans != -1) {
            return ans;
        }

        // Search right (descending)
        return binarySearch(
            mountainArr,
            target,
            peak + 1,
            n - 1,
            false
        );
    }

    private int binarySearch(
        MountainArray arr,
        int target,
        int l,
        int r,
        boolean ascending
    ) {

        while (l <= r) {

            int mid = l + (r - l) / 2;
            int val = arr.get(mid);

            if (val == target) {
                return mid;
            }

            if (ascending) {

                if (val < target)
                    l = mid + 1;
                else
                    r = mid - 1;

            } else {

                if (val < target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }
}