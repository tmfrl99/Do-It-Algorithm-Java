package chap06.practice;

import java.util.Scanner;

public class Q5 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void bubbleSort(int[] a, int n) {
		int compCnt = 0;
		int swapCnt = 0;

		for (int i = 0; i < n - 1; i++) {
			System.out.printf("패스%d : \n", i + 1);
			int exchg = 0;

			if (i % 2 == 1) { // 홀수
				for (int j = n - 1; j > i; j--) {
					compCnt++;
					if (a[j - 1] > a[j]) {
						swap(a, j - 1, j);
						exchg++;
						swapCnt++;
					}
				}
			}
			else { // 짝수
				for (int j = i; j < n - 1; j++) {
					compCnt++;
					if (a[j] > a[j + 1]) {
						swap(a, j, j + 1);
						exchg++;
						swapCnt++;
					}
				}
			}
			for (int j = 0; j < n; j++)
				System.out.printf("%3d  ", a[j]);
			System.out.println();

			if (exchg == 0) break;
		}
		System.out.printf("비교를 %d회 했습니다.\n", compCnt);
		System.out.printf("교환을 %d회 했습니다.\n", swapCnt);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬");
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
