package main;

public class Solution2 {

	public static void main(String[] args) {
		calculate(5);
	}
	
	public static String calculate(int n) {
		StringBuffer sb = new StringBuffer();
		
		int i, j;

		// LOOP FOR HUT PYRAMID
		for (i = 0, j = 0; i < n; j++) {
			if (j == n + i) {
				j = -1;
				++i;
				System.out.print("\n");
				sb.append("\n");
			} 
			// print Center Star triangle
			else if ((i + j) >= n - 1) {
				System.out.print("*");
				sb.append("*");
			} else {
				System.out.print(" ");
				sb.append(" ");
			}
		}

		// LOOPS FOR LOWER WALLS
		for (int k = 0; k < 3; k++) {
			// Left and right rectangle
			for (int l = 0; l < n - 1 + i; l++) {
				if (l <= 2 || (l <= n - 1 + i && l >= n - 4 + i)) {
					System.out.print("*");
					sb.append("*");
				} else {
					System.out.print(" ");
					sb.append(" ");
				}
			}
			System.out.print("\n");
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
