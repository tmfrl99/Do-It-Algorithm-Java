package chap05.practice;

import java.util.Scanner;

public class Q1 {
	public static int factorial(int n) {
		int res = 1;
		while (n > 1) {
			res *= n;
			n--;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요. : ");
		int x = stdIn.nextInt();

		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}
}
