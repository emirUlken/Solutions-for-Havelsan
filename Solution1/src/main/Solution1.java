package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1 {
	static final int MOD = 1000000007;
	static final int MAX = 100005;
	static int n = 0, m = 0, q = 0;
	static int[] prime = new int[100007];
	static int[][] a = new int[1005][1005];
	static long[][] dp = new long[1005][1005];
	static int[][] mark = new int[1005][1005];
	static Pair[] ans = new Pair[100005];

	public static void main(String[] args) {

		calculate();

	}

	public static String calculate() {
		StringBuffer sb = new StringBuffer();
		File file = new File("input.txt");

		try {
			Scanner sizeScanner = new Scanner(file);
			String[] temp = sizeScanner.nextLine().split(" ");
			n = Integer.valueOf(temp[0]);
			m = Integer.valueOf(temp[1]);
			sizeScanner.close();

			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			for (int i = 1; i <= n; i++) {
				String[] numbers = scanner.nextLine().split(" ");
				for (int j = 1; j <= m; j++) {
					a[i][j] = Integer.parseInt(numbers[j - 1]);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 2; i * i <= 100005; i++) {
			if (prime[i] == 0) {
				for (int j = i * i; j <= 100005; j += i) {
					prime[j] = 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (prime[a[i][j]] == 0)
					a[i][j] = 1;
				else
					a[i][j] = 0;
			}
		}

		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1) {
					continue;
				}

				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % MOD;

				if (a[i][j] == 0) {
					dp[i][j] = 0;
				}
			}

		}

		System.out.println(dp[n][m]);
		sb.append(dp[n][m] + "\n");

		dfs(1, 1, 1);

		for (int i = 1; i <= q; i++) {
			System.out.println(ans[i].key() + " " + ans[i].value());
			sb.append(ans[i].key() + " " + ans[i].value() + "\n");
		}

		return sb.toString();
	}

	public static void dfs(int i, int j, int k) {
		if (a[i][j] == 0 || i > n || j > m || mark[i][j] > 0 || q > 0) {
			return;
		}

		mark[i][j] = 1;
		ans[k] = new Pair(i, j);

		if (i == n && j == m) {
			q = k;
			return;
		}

		dfs(i + 1, j + 1, k + 1);
		dfs(i + 1, j, k + 1);
		dfs(i, j + 1, k + 1);
	}

	static class Pair {
		private final Integer key;
		private final Integer value;

		public Pair(Integer aKey, Integer aValue) {
			key = aKey;
			value = aValue;
		}

		public Integer key() {
			return key;
		}

		public Integer value() {
			return value;
		}
	}
}
