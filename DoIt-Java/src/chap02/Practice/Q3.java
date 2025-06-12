package chap02.Practice;

import java.util.Scanner;

public class Q3 {
	static int sumOf(int[] a) {
		int sum = 0;

		for (int n : a) {
			sum += n;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = stdIn.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		System.out.println("배열 x의 모든 요소의 합계는 " + sumOf(x));
	}
}
