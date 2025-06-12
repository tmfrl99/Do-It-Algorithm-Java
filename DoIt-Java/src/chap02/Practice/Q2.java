package chap02.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	static void swap(int[] a, int idx1, int idx2) {
		System.out.println("a[" + idx1 + "]과 a[" + idx2 + "]를 교환합니다.");
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
			/*for (int k : a) {
				System.out.print(k + " ");
			}
			System.out.println();*/

			System.out.println(Arrays.toString(a));
		}
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = stdIn.nextInt();

		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = stdIn.nextInt();
		}

		reverse(a);
		System.out.println("역순 정렬을 마쳤습니다.");
	}
}
