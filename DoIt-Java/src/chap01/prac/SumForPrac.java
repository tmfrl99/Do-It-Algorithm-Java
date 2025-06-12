package chap01.prac;

import java.util.Scanner;

public class SumForPrac {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("Q7의 답");
		prac7(n);
		System.out.println("\n\nQ8의 답");
		prac8(n);
		System.out.println("\nQ9의 답");
		System.out.println(sumof(6, 4));
	}

	public static void prac7(int n) {
		int sum = 0;

		for (int i = 1; i < n + 1; i++) {
			if (i > 1) {
				System.out.print(" + " + i);
			} else {
				System.out.print(i);
			}
			sum += i;
		}
		System.out.print(" = " + sum);
	}

	public static void prac8(int n) {
		int sum = (1 + n) * (n / 2);
		if (n % 2 == 1) {
			sum += (n - n / 2);
		}
		System.out.println("1부터 " + n + "까지의 합: " + sum);
	}

	static int sumof(int a, int b) {
		int sum = 0;
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}

		for (int i = a; i <= b; i++) {
			sum += i;
		}

		return sum;
	}
}
