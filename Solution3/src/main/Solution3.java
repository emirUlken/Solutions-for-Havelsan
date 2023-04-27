package main;

public class Solution3 {
	static int size;
	static int[] arr;

	public static void main(String[] args) {
		calculate();
	}

	// Function to merge two sorted arrays
	static int merge(int arr[], int temp[], int l, int m, int r, int K) {

		// i: index to left subarray
		int i = l;

		// j: index to right subarray
		int j = m + 1;

		// Stores count of pairs that
		// satisfy the given condition
		int cnt = 0;

		for (i = l; i <= m; i++) {
			boolean found = false;

			// Traverse to check for the
			// valid conditions
			while (j <= r) {

				// If condition satisfies
				if (Math.abs(arr[i] - arr[j]) == (j+1)*(j+1) + (i+1)*(i+1)) {
					found = true;
				} else
					break;
				j++;
			}

			// While a[i] > K*a[j] satisfies
			// increase j

			// All elements in the right
			// side of the left subarray
			// also satisfies
			if (found == true) {
				cnt += j - (m + 1);
				j--;
			}
		}

		// Sort the two given arrays and
		// store in the resultant array
		int k = l;
		i = l;
		j = m + 1;

		while (i <= m && j <= r) {

			if (arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}

		// Elements which are left
		// in the left subarray
		while (i <= m)
			temp[k++] = arr[i++];

		// Elements which are left
		// in the right subarray
		while (j <= r)
			temp[k++] = arr[j++];

		for (i = l; i <= r; i++)
			arr[i] = temp[i];

		// Return the count obtained
		return cnt;
	}

	// Function to partition array into two halves
	static int mergeSortUtil(int arr[], int temp[], int l, int r, int K) {
		int cnt = 0;
		if (l < r) {

			// Same as (l + r) / 2, but avoids
			// overflow for large l and h
			int m = (l + r) / 2;

			// Sort first and second halves
			cnt += mergeSortUtil(arr, temp, l, m, K);
			cnt += mergeSortUtil(arr, temp, m + 1, r, K);

			// Call the merging function
			cnt += merge(arr, temp, l, m, r, K);
		}
		return cnt;
	}

	// Function to print the count of
	// required pairs using Merge Sort
	static int mergeSort(int arr[], int N, int K) {
		int temp[] = new int[N];
		int result = mergeSortUtil(arr, temp, 0, N - 1, K);
		return result;
	}

	public static int calculate() {
		int arr[] = { 4, 9, 6, 29, 30 };
        int N = arr.length;
        int K = 2;
     
        // Function Call
        return mergeSort(arr, N, K);
	}

}
