package chap03.practice;

import java.util.Scanner;

public class Q3 {
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[cnt++] = i;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		int[] idxArr = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		System.out.print("검색할 값: ");
		int ky = stdIn.nextInt();

		int cnt = searchIdx(x, num, ky, idxArr);

		if (cnt == 0)
			System.out.println("그 값의 요소가 없습니다.");
		else {
			for (int i = 0; i < cnt; i++)
				System.out.println(ky + "은(는) x[" + idxArr[i] + "]에 있습니다.");
		}
	}
}
