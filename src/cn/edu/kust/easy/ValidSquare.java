package cn.edu.kust.easy;

/**
 *
 * 367. Valid Perfect Square
 * pass
 */
public class ValidSquare {
    public boolean isPerfectSquare(int num) {

        boolean flag = false;
        long start = 0;
        long end = num;
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (num == mid * mid) {
                flag = true;
                break;
            }

            if (start == end ) {
                break;
            }

            if (num < mid * mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return flag;
        //return binarySearch(num, 0, num / 2) || binarySearch(num, num / 2 + 1, num);
    }

    /**
     * When the num is very large
     * recursion will throw StackOverflowError
     */
    private boolean binarySearch(int num, int start, int end) {
        if (start > end){
            return false;
        }

        if (start == end) {
            if (num == start * start) {
                return true;
            } else {
                return false;
            }
        }

        int mid = (end + start) / 2;

        if (num == mid * mid) {
            return true;
        }

        if (num < mid * mid) {
            return binarySearch(num, start, mid);
        } else {
            return binarySearch(num, mid + 1, end);
        }
    }
}
