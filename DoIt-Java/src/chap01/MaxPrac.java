package chap01;

import java.util.Scanner;

public class MaxPrac {
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if (b > max) max = b;
		if (c > max) max = c;
		if (d > max) max = d;

		return max;
	}

	static int min3(int a, int b, int c) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;

		return min;
	}

	static int min4(int a, int b, int c, int d) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		if (d < min) min = d;

		return min;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("네 정수를 입력합니다.");
		System.out.print("a의 값 : "); int a = stdIn.nextInt();
		System.out.print("b의 값 : "); int b = stdIn.nextInt();
		System.out.print("c의 값 : "); int c = stdIn.nextInt();
		System.out.print("d의 값 : "); int d = stdIn.nextInt();

		System.out.println("max4 = " + max4(a, b, c, d));
		System.out.println("min3 = " + min3(a, b, c));
		System.out.println("min4 = " + min4(a, b, c, d));
	}
}
