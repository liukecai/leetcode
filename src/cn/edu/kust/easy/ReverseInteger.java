package cn.edu.kust.easy;

/**
 *
 * 7. Reverse Integer
 * pass
 */
public class ReverseInteger {
	public int reverse(int x) {
		if (x == Integer.MIN_VALUE)
			return 0;
		if (x == 0)
			return x;
		int s = 1;
		if (x < 0) {
			x = -x;
			s = 0;
		}
		Integer temp = new Integer(x);
		char[] str = temp.toString().toCharArray();
		StringBuffer sb = new StringBuffer();
		int i = str.length - 1;
		while (i >= 0) {
			sb.append(str[i]);
			i--;
		}
		long r1 = Long.parseLong(sb.toString(), 10);
		if (s == 0)
			r1 = -r1;
		if (r1 > Integer.MAX_VALUE || r1 < Integer.MIN_VALUE)
			return 0;
		else 
			return (int) r1;
	}

	public int reverse2(int x) {
		long rev= 0;
		while( x != 0){
			rev= rev*10 + x % 10;
			x= x/10;
			if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		return (int) rev;
	}
	
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(10));
		System.out.println(r.reverse(23));
	}
}
