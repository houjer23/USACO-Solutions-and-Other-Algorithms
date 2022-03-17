import java.util.*;

class Choice implements Comparable<Choice> {
	long sx;
	long sy;
	long sn;

	public Choice(long sx, long sy, long sn) {
		this.sx = sx;
		this.sy = sy;
		this.sn = sn;
	}

	@Override
	public int compareTo(Choice c) {
		if (this.sx != c.sx) {
			return this.sx < c.sx ? -1 : 1;
		}
		if (this.sy != c.sy) {
			return this.sy < c.sy ? -1 : 1;
		}

		if (this.sn == c.sn) {
			return 0;
		}
		return this.sn < c.sn ? -1 : 1;
	} 
}

public class Robot_Instructions {
	private static int N;
	private static long xg, yg;
	private static long[] x = new long[100];
	private static long[] y = new long[100];
	private static long[] res = new long[100];
	private static Choice[] c = new Choice[1 << 20 + 1];

	private static void init() {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		xg = scanner.nextLong();
		yg = scanner.nextLong();
		for (int i = 1; i <= N; i++) {
			x[i] = scanner.nextLong();
			y[i] = scanner.nextLong();
		}
		scanner.close();

		return;
	}

	private static int binarySearchBound(Choice[] c, int start, int end, Choice target, boolean isUpperBound) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isUpperBound) {
            	if (c[mid].compareTo(target) <= 0) {
	                start = mid + 1;
	            } else {
	                end = mid;
	            }
            } else {
            	if (c[mid].compareTo(target) < 0) {
	                start = mid + 1;
	            } else {
	                end = mid;
	            }
            }
        }
        return start;
	}

	public static void main(String[] args) {
		init();

	    for (int j = 0; j < (1 << (N/2)); j++) {
	        int i = 0, jj = j;
	        long sx = 0, sy = 0, sn = 0;
	        while (jj > 0) {
	            i++;
	            if ((jj & 1) == 1) {
	                sx += x[i];
	                sy += y[i];
	                sn++;
	            }
	            jj >>= 1;
	        }

	        c[j] = new Choice(sx, sy, sn);
	    }

	    c[1 << (N/2)] = new Choice((long)1 << 60, (long)1 << 60, 0);
    	Arrays.sort(c, 0, (1 << (N/2)));
    	   	    
    	for (int j = 0; j < (1 << (N - N/2)); j++) {
	        int i = N/2, jj = j;
	        long sx = 0, sy = 0, sn = 0;
	        while (jj > 0) {
	            i++;
	            if ((jj & 1) == 1) {
	                sx += x[i];
	                sy += y[i];
	                sn++;
	            }
	            jj >>= 1;
	        }

	        Choice temp = new Choice(xg-sx, yg-sy, 0);
	        int index = binarySearchBound(c, 0, 1 << (N/2), temp, false);

	        while ((c[index].sx == xg-sx) && (c[index].sy == yg-sy)) {
	            int nextIndex = binarySearchBound(c, 0, 1 << (N/2), c[index], true);
	            res[(int)(c[index].sn + sn)] += (long) (nextIndex - index);
	            index = nextIndex;
	        }
	    }
	    
	    for (int i = 1; i <= N; i++) {
	        System.out.println(String.format("%d", res[i]));
	    }
		return;
	}
 
}