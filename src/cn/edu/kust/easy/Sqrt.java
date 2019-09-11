package cn.edu.kust.easy;

/**
 *
 * 69. Sqrt
 * pass
 */
public class Sqrt {
    public int mySqrt1(int x) {
        long i = 0;
        long mid = 0;
        for (; i <= x; i++) {
            mid = i * i;
            if (mid >= x) {
                break;
            }
        }
        if (mid == x) {
            return (int) i;
        } else {
            return (int) i - 1;
        }
    }

    public int mySqrt(int x) {
        // sqrt(x) = 2 * (sqrt(x) / 2) = 2 * sqrt(x / 4)

        if (x < 2) {
            return x;
        }

        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }

    public int mySqrt2(int x) {
        // x ^ (1/2) = e ^ (1/2 * log x)

        if (x < 2) {
            return x;
        }

        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
