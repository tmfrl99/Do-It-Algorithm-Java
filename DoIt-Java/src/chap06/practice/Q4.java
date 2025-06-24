package chap06.practice;

import java.util.Scanner;

public class Q4 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void bubbleSort(int[] a, int n) {
		int compCnt = 0;
		int swapCnt = 0;
		int m = 0;
		int i = 1;

		while(m < n - 1) {
			System.out.printf("패스%d : \n", i++);
			int last = n - 1;
			for (int j = n - 1; j > m; j--) {
				for (int k = 0; k < n - 1; k++)
					System.out.printf("%3d %c", a[k], (k != j - 1) ? ' ' : a[j - 1] > a[j] ? '+' : '-');

				System.out.printf("%3d\n", a[n - 1]);
				compCnt++;

				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
					swapCnt++;
				}
			}
			for (int j = 0; j < n; j++)
				System.out.printf("%3d  ", a[j]);
			System.out.println();
			m = last;
		}

		System.out.printf("비교를 %d회 했습니다.\n", compCnt);
		System.out.printf("교환을 %d회 했습니다.\n", swapCnt);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬(버전 2)");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);
	}
}
